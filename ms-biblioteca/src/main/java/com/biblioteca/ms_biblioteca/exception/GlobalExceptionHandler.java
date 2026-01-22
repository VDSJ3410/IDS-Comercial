package com.biblioteca.ms_biblioteca.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ApiError> handleBusiness(BusinessException ex) {
        return ResponseEntity
                .status(ex.getCode())
                .body(new ApiError(ex.getCode(), ex.getMessage()));
    }


    @ExceptionHandler(InvalidCodeException.class)
    public ResponseEntity<ApiError> handleInvalidCode(InvalidCodeException ex) {
        return ResponseEntity
                .status(ex.getCode())
                .body(new ApiError(ex.getCode(), ex.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleAll(Exception ex) {
        return ResponseEntity
                .status(500)
                .body(new ApiError(500, "Error interno: " + ex.getMessage()));
    }
}





