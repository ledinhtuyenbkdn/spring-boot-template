package com.ledinhtuyenbkdn.springboottemplate.exception;

import com.ledinhtuyenbkdn.springboottemplate.constant.ExceptionConstants;

public class BusinessException extends RuntimeException{

    private final ExceptionConstants exceptionConstant;

    public BusinessException(ExceptionConstants exceptionConstant) {
        super(exceptionConstant.getCode());
        this.exceptionConstant = exceptionConstant;
    }

    public ExceptionConstants getExceptionConstant() {
        return exceptionConstant;
    }
}
