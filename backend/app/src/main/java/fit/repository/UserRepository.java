package fit.repository;

import fit.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  public void save(User user) {
    try {
      String sql = "INSERT INTO users (nameUser, email, password, cpf, pix) VALUES (:name, :email, :password, :cpf, :pix)";
      Map<String, Object> parameters = new HashMap<>();
      parameters.put("name", user.getName());
      parameters.put("email", user.getEmail());
      parameters.put("password", user.getPassword());
      parameters.put("cpf", user.getCpf());
      parameters.put("pix", user.getPix());
      jdbcTemplate.update(sql, parameters);
    } catch (DataAccessException e) {
      throw new RuntimeException("An error occurred while executing the query: ", e);
    }
  }

  public User findByUserEmailAndPassword(String email, String password) {
	  User user = null;
    try {
    	user = jdbcTemplate.query("SELECT * FROM users WHERE email = ? AND password = ?", 
    	        new PreparedStatementSetter() {
    	            public void setValues(PreparedStatement ps) throws SQLException {
    	                ps.setString(1, email);
    	                ps.setString(2, password);
    	            }
    	        }, 
    	        new ResultSetExtractor<User>() {
    	            public User extractData(ResultSet rs) throws SQLException, DataAccessException {
    	                if (rs.next()) {
    	                    User user = new User(
    	                        rs.getInt("id"),
    	                        rs.getString("nameUser"),
    	                        rs.getString("email"),
    	                        rs.getString("password"),
    	                        rs.getString("cpf"),
    	                        rs.getString("pix"));
    	                    return user;
    	                } else {
    	                    return null;
    	                }
    	            }
    	        });
    } catch (DataAccessException e) {
      throw new RuntimeException("An error occurred while executing the query: ", e);
    }
    
    return user;
  }

  public Boolean checkIfUserAlreadyExists(String email, String cpf) {
	    try {
	        String sql = "SELECT COUNT(*) FROM users WHERE email = ? AND cpf = ?";
	        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, email, cpf);
	        return count != null && count > 0;
	    } catch (DataAccessException e) {
	        throw new RuntimeException("An error occurred while executing the query: ", e);
	    }
	}
}