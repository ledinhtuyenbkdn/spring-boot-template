package com.ledinhtuyenbkdn.springboottemplate.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BusinessExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorMessage> handleBusinessException(BusinessException businessException) {
        ErrorMessage errorMessage = new ErrorMessage(businessException.getExceptionConstant().getCode(),
                businessException.getExceptionConstant().getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorMessage);
    }
}
