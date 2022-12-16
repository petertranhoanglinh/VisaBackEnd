package com.example.backend.dto.exception;

public class Erors {

    public long statusCode;
    public String message;

    public Erors(long statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public long getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(long statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
