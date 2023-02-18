package com.example.itplanet.exception.account;

import org.springframework.http.HttpStatus;

public class AccountNotFound extends RuntimeException{
    private HttpStatus httpStatus;
    public AccountNotFound(HttpStatus httpStatus){
        this.httpStatus = httpStatus;
    }
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
