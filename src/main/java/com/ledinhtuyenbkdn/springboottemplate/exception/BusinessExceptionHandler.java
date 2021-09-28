package com.ledinhtuyenbkdn.springboottemplate.exception;

import com.ledinhtuyenbkdn.springboottemplate.util.MessageUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Component
public class BusinessExceptionHandler {

    private final MessageUtils messageUtils;

    public BusinessExceptionHandler(MessageUtils messageUtils) {
        this.messageUtils = messageUtils;
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponse> handleBusinessException(BusinessException exception) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .code(exception.getMessage())
                .message(messageUtils.getMessageValue(exception.getMessage()))
                .build();
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
    }
}
