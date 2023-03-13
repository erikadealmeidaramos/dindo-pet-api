package fit.exception.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import fit.exception.DuplicatedUserException;
import fit.exception.InvalidTokenException;
import fit.exception.MissingHeaderException;
import fit.exception.UserCreationException;
import fit.exception.UserNotFoundException;
import fit.model.ApiError;

@ControllerAdvice
public class GlobalCustomExceptionHandler {

  private static final Logger logger = LoggerFactory.getLogger(GlobalCustomExceptionHandler.class);

  @ExceptionHandler(UserCreationException.class)
  public ResponseEntity<Object> handleUserCreationException(UserCreationException ex) {
    logger.error("User creation Exception: ", ex);

    ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());

    return new ResponseEntity<>(apiError, apiError.getStatus());
  }

  @ExceptionHandler(UserNotFoundException.class)
  public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex) {
    logger.error("User not found Exception: ", ex);

    ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, ex.getMessage());

    return new ResponseEntity<>(apiError, apiError.getStatus());
  }

  @ExceptionHandler(DuplicatedUserException.class)
  public ResponseEntity<Object> handleDuplicatedUserException(DuplicatedUserException ex) {
    logger.error("Duplicated user exception: ", ex);

    ApiError apiError = new ApiError(HttpStatus.CONFLICT, ex.getMessage());

    return new ResponseEntity<>(apiError, apiError.getStatus());
  }

  @ExceptionHandler(InvalidTokenException.class)
  public ResponseEntity<Object> handleInvalidTokenException(InvalidTokenException ex) {
    logger.error("Invalid token Exception: ", ex);

    ApiError apiError = new ApiError(HttpStatus.UNAUTHORIZED, ex.getMessage());

    return new ResponseEntity<>(apiError, apiError.getStatus());
  }

  @ExceptionHandler(MissingHeaderException.class)
  public ResponseEntity<Object> handleMissingHeaderException(MissingHeaderException ex) {
    logger.error("Missing header Exception: ", ex);

    ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getMessage());
    return new ResponseEntity<>(apiError, apiError.getStatus());
  }
}
