package com.academy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(StudenteNotFoundException.class)
    public ResponseEntity<StudenteNotFoundExceptionResponse> StudentNotFound(StudenteNotFoundException studenteNotFoundException) {

        StudenteNotFoundExceptionResponse studenteNotFoundExceptionResponse = new StudenteNotFoundExceptionResponse(
                studenteNotFoundException.getMessage(),
                studenteNotFoundException.getId(),
                System.currentTimeMillis());
        ResponseEntity<StudenteNotFoundExceptionResponse> rispostaDiErrore = new ResponseEntity<>(studenteNotFoundExceptionResponse, HttpStatus.NOT_FOUND);
        return rispostaDiErrore;
    }

    @ExceptionHandler(UserAlreadyExistException.class)
    public ResponseEntity<String> handleRuntimeException(UserAlreadyExistException userEx) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(userEx.getMessage());
    }

    @ExceptionHandler(ProfiloStudenteNotFoundException.class)
    public ResponseEntity<String> handleRuntimeException(ProfiloStudenteNotFoundException profEx) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(profEx.getMessage());
    }
}
