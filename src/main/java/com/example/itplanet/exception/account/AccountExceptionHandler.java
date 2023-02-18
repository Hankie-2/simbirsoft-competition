package com.example.itplanet.exception.account;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AccountExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AccountNotFound.class)
    public ResponseEntity<?> handleAccountNotFound(AccountNotFound e){
        return new ResponseEntity<>(e.getHttpStatus());
    }

    @ExceptionHandler(AccountIsExists.class)
    public ResponseEntity<?> handleAccountIsExistsException(AccountIsExists e){
        return new ResponseEntity<>(e.getHttpStatus());
    }

    @ExceptionHandler(AccountAuthenticationException.class)
    public ResponseEntity<?> handleAuthenticationException(AccountAuthenticationException e){
        return new ResponseEntity<>(e.getHttpStatus());
    }

}
