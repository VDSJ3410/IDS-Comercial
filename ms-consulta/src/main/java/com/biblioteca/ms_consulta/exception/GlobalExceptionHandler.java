package com.biblioteca.ms_consulta.exception;

import feign.RetryableException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.ResourceAccessException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 1️⃣ TIMEOUT FUNCIONAL (Feign ReadTimeout, CircuitBreaker, fallback)
     */
    @ExceptionHandler({BusinessException.class, RetryableException.class})
    public ResponseEntity<ApiError> handleTimeout(Exception ex) {

        return ResponseEntity
                .status(400)
                .body(new ApiError(
                        400,
                        "Error",
                        System.currentTimeMillis() / 1000,
                        "El MS 1 tardo mas de lo esperado"
                ));
    }

    /**
     * 2️⃣ MS1 REALMENTE APAGADO (no hay conexión)
     */
    @ExceptionHandler(ResourceAccessException.class)
    public ResponseEntity<ApiError> handleOffline(ResourceAccessException ex) {

        return ResponseEntity
                .status(500)
                .body(new ApiError(
                        500,
                        "Error",
                        System.currentTimeMillis() / 1000,
                        "El MS 1 se encuentra fuera de linea"
                ));
    }

    /**
     * 3️⃣ CUALQUIER OTRO ERROR REAL
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleAll(Exception ex) {

        return ResponseEntity
                .status(500)
                .body(new ApiError(
                        500,
                        "Error",
                        System.currentTimeMillis() / 1000,
                        "Error interno del MS2: " + ex.getMessage()
                ));
    }
}


















