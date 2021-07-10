package com.ledinhtuyenbkdn.springboottemplate.constant;

public enum ExceptionConstants {
    NOT_FOUND_PET("not-found-pet", "Not found pet");

    private final String code;

    private final String message;

    ExceptionConstants(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
