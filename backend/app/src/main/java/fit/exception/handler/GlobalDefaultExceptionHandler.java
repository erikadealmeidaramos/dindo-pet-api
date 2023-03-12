package fit.exception.handler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.BatchUpdateException;
import java.sql.SQLException;
import java.sql.SQLNonTransientConnectionException;
import java.sql.SQLRecoverableException;
import java.sql.SQLSyntaxErrorException;
import java.sql.SQLTimeoutException;
import java.sql.SQLTransientConnectionException;
import java.sql.SQLTransientException;
import fit.model.ApiError;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {

  private static final Logger logger = LogManager.getLogger(GlobalDefaultExceptionHandler.class);

  @ExceptionHandler(Exception.class)
  public ResponseEntity<Object> handleException(Exception ex, HttpServletRequest request) {
    logger.error("An error occurred: ", ex);

    ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, "An error occurred. Please try again later.");

    return new ResponseEntity<Object>(apiError, apiError.getStatus());
  }

  @ExceptionHandler(ServletException.class)
  public ResponseEntity<Object> handleServletException(ServletException ex, HttpServletRequest request) {
    logger.error("An error occurred: ", ex);

    ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, "An error occurred. Please try again later.");

    return new ResponseEntity<Object>(apiError, apiError.getStatus());
  }

  @ExceptionHandler(value = { IllegalArgumentException.class, IllegalStateException.class })
  public ResponseEntity<Object> handleBadRequest(RuntimeException ex) {
    ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, "Bad Request: " + ex.getMessage());
    return new ResponseEntity<Object>(apiError, apiError.getStatus());
  }

  @ExceptionHandler(NullPointerException.class)
  public ResponseEntity<Object> handleNullPointerException(NullPointerException ex) {
    logger.error("NullPointerException: ", ex);

    ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR,
        "An unexpected null pointer exception occurred.");

    return new ResponseEntity<Object>(apiError, apiError.getStatus());
  }

  @ExceptionHandler(NumberFormatException.class)
  public ResponseEntity<Object> handleNumberFormatException(NumberFormatException ex) {
    logger.error("NumberFormatException: ", ex);

    ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, "Invalid number format.");

    return new ResponseEntity<Object>(apiError, apiError.getStatus());
  }

  @ExceptionHandler(IndexOutOfBoundsException.class)
  public ResponseEntity<Object> handleIndexOutOfBoundsException(IndexOutOfBoundsException ex) {
    logger.error("IndexOutOfBoundsException: ", ex);

    ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, "Index out of bounds.");

    return new ResponseEntity<Object>(apiError, apiError.getStatus());
  }

  @ExceptionHandler(IOException.class)
  public ResponseEntity<Object> handleIOException(IOException ex) {
    logger.error("IOException: ", ex);

    ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, "An I/O exception occurred.");

    return new ResponseEntity<Object>(apiError, apiError.getStatus());
  }

  @ExceptionHandler(SQLException.class)
  public ResponseEntity<Object> handleSQLException(SQLException ex) {
    logger.error("SQL Exception: ", ex);

    ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR,
        "An error occurred while executing a SQL statement. Please try again later.");

    return new ResponseEntity<Object>(apiError, apiError.getStatus());
  }

  @ExceptionHandler(BatchUpdateException.class)
  public ResponseEntity<Object> handleBatchUpdateException(BatchUpdateException ex) {
    logger.error("Batch Update Exception: ", ex);

    ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR,
        "An error occurred while executing a batch update. Please try again later.");

    return new ResponseEntity<Object>(apiError, apiError.getStatus());
  }

  @ExceptionHandler(SQLTimeoutException.class)
  public ResponseEntity<Object> handleSQLTimeoutException(SQLTimeoutException ex) {
    logger.error("SQL Timeout Exception: ", ex);

    ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR,
        "An error occurred while waiting for a SQL statement to complete. Please try again later.");

    return new ResponseEntity<Object>(apiError, apiError.getStatus());
  }

  @ExceptionHandler(SQLSyntaxErrorException.class)
  public ResponseEntity<Object> handleSQLSyntaxErrorException(SQLSyntaxErrorException ex) {
    logger.error("SQL Syntax Error Exception: ", ex);

    ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR,
        "An error occurred while executing a SQL statement due to a syntax error. Please try again later.");

    return new ResponseEntity<Object>(apiError, apiError.getStatus());
  }

  @ExceptionHandler(SQLNonTransientConnectionException.class)
  public ResponseEntity<Object> handleSQLNonTransientConnectionException(SQLNonTransientConnectionException ex) {
    logger.error("SQL Non-Transient Connection Exception: ", ex);

    ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR,
        "An error occurred while attempting to connect to the database. Please try again later.");

    return new ResponseEntity<Object>(apiError, apiError.getStatus());
  }

  @ExceptionHandler(SQLTransientConnectionException.class)
  public ResponseEntity<Object> handleSQLTransientConnectionException(SQLTransientConnectionException ex) {
    logger.error("SQL Transient Connection Exception: ", ex);

    ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR,
        "An error occurred while attempting to connect to the database. Please try again later.");

    return new ResponseEntity<Object>(apiError, apiError.getStatus());
  }

  @ExceptionHandler(SQLRecoverableException.class)
  public ResponseEntity<Object> handleSQLRecoverableException(SQLRecoverableException ex) {
    logger.error("SQL Recoverable Exception: ", ex);

    ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR,
        "An error occurred that can be recovered from. Please try again later.");

    return new ResponseEntity<Object>(apiError, apiError.getStatus());
  }

  @ExceptionHandler(SQLTransientException.class)
  public ResponseEntity<Object> handleSQLTransientException(SQLTransientException ex) {
    logger.error("SQL Transient Exception: ", ex);

    ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR,
        "An error occurred that can be recovered from. Please try again later.");

    return new ResponseEntity<Object>(apiError, apiError.getStatus());
  }

}