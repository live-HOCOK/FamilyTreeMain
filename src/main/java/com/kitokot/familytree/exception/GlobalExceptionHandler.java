package com.kitokot.familytree.exception;


import com.kitokot.familytree.exception.user.CreateUserException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(CreateUserException.class)
  public ResponseEntity<?> handleDuplicate(CreateUserException ex) {
    return ResponseEntity
      .status(HttpStatus.CONFLICT)
      .body(Map.of("message", ex.getMessage()));
  }

  @ExceptionHandler(CannotCreateTransactionException.class)
  public ResponseEntity<?> handleDatabaseError(CannotCreateTransactionException ex) {
    return ResponseEntity
      .status(HttpStatus.SERVICE_UNAVAILABLE)
      .body(Map.of("message", "Database is unavailable"));
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<?> handleUnexpected(Exception ex) {
    return ResponseEntity
      .status(HttpStatus.INTERNAL_SERVER_ERROR)
      .body(Map.of("message", "Internal server error"));
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<?> handleValidation(MethodArgumentNotValidException ex) {
    return ResponseEntity
      .badRequest()
      .body(Map.of("message", "Validation failed"));
  }

  @ExceptionHandler(HttpMessageNotReadableException.class)
  public ResponseEntity<?> handleNotReadable(HttpMessageNotReadableException ex) {
    return ResponseEntity
      .badRequest()
      .body(Map.of("message", "Bad request"));
  }

}
