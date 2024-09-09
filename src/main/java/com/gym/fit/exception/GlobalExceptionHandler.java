package com.gym.fit.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<String> handleCustomException(CustomException ex) {
        HttpStatus status;
        switch (ex.getErrorCode()) {
            case "USER_NOT_FOUND":
                status = HttpStatus.NOT_FOUND;
                break;
            case "INVALID_TOKEN":
                status = HttpStatus.UNAUTHORIZED;
                break;
            case "USER_ALREADY_EXISTS":
                status = HttpStatus.CONFLICT;
                break;
            case "EMAIL_ALREADY_EXISTS":
                status = HttpStatus.CONFLICT;
                break;
            default:
            	
                status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return ResponseEntity.status(status).body(ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                             .body("An unexpected error occurred: " + ex.getMessage());
    }
}

