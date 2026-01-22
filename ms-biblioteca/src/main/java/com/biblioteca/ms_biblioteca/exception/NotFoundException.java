package com.biblioteca.ms_biblioteca.exception;

public class NotFoundException extends RuntimeException {

    private final int code;

    public NotFoundException(int code, String message) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}



