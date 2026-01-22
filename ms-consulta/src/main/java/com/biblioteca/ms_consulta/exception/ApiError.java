package com.biblioteca.ms_consulta.exception;

public class ApiError {

    private int code;
    private String type;
    private long timestamp;
    private String details;

    public ApiError(int code, String type, long timestamp, String details) {
        this.code = code;
        this.type = type;
        this.timestamp = timestamp;
        this.details = details;
    }

    public ApiError(int code, String details) {
        this.code = code;
        this.type = "Error";
        this.timestamp = System.currentTimeMillis() / 1000;
        this.details = details;
    }

    public int getCode() {
        return code;
    }

    public String getType() {
        return type;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getDetails() {
        return details;
    }
}







