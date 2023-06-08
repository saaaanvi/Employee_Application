package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

 @ExceptionHandler(RecordsNotFoundException.class)
 public ResponseEntity<String> handleRecordsNotFoundException(RecordsNotFoundException exception) {
  return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
 }
}
