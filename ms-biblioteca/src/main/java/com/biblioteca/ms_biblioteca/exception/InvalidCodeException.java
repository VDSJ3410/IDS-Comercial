package com.biblioteca.ms_biblioteca.exception;

public class InvalidCodeException extends RuntimeException {

    private final int code;

    public InvalidCodeException(int code, String message) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}

