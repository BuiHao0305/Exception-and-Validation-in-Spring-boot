package com.springpro.jpa.Exception;

public enum ErrorCode {
    USER_EXITSED(1001,"name exitsed");

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private int code;
    private String message;


    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}