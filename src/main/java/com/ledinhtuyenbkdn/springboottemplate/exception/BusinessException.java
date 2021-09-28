package com.ledinhtuyenbkdn.springboottemplate.exception;

public class BusinessException extends RuntimeException{

    public BusinessException(String message) {
        super(message);
    }
}
