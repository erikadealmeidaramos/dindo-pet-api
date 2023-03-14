package fit.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;

import org.springframework.core.annotation.Order;
import org.springframework.core.Ordered;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.filter.GenericFilterBean;

import fit.exception.InvalidTokenException;
import fit.exception.MissingHeaderException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class JwtFilter extends GenericFilterBean {
  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
      throws IOException, ServletException, InvalidTokenException, MissingHeaderException {
    final HttpServletRequest request = (HttpServletRequest) servletRequest;
    final HttpServletResponse response = (HttpServletResponse) servletResponse;
    final String authHeader = request.getHeader("authorization");
    if ("OPTIONS".equals(request.getMethod())) {
      response.setStatus(HttpServletResponse.SC_OK);
      filterChain.doFilter(request, response);
    } else {
      if (authHeader == null) {
        throw new MissingHeaderException("Header is missing");
      }
      if (!authHeader.startsWith("Bearer ")) {
        throw new InvalidTokenException("Invalid token. Bearer missing");
      }
    }
    try {
      final String token = authHeader.substring(7);
      Claims claims = Jwts.parser().setSigningKey("secret").parseClaimsJws(token).getBody();
      request.setAttribute("claims", claims);

      Map<String, String[]> parameters = servletRequest.getParameterMap();
      for (String name : parameters.keySet()) {
        String[] values = parameters.get(name);
        if (values.length > 0) {
          request.setAttribute(name, values[0]);
        }
      }

      filterChain.doFilter(request, response);
    } catch (JwtException e) {
      throw new InvalidTokenException("Invalid token");
    }
  }

}