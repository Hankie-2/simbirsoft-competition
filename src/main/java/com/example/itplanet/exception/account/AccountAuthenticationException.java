package com.example.itplanet.exception.account;

import org.springframework.http.HttpStatus;

public class AccountAuthenticationException extends RuntimeException{
    private HttpStatus httpStatus;
    public AccountAuthenticationException(HttpStatus httpStatus){
        this.httpStatus = httpStatus;
    }
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
