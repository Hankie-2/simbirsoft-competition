package com.example.itplanet.exception.account;

import org.springframework.http.HttpStatus;

public class AccountIsExists extends RuntimeException{

    private HttpStatus httpStatus;
    public AccountIsExists(HttpStatus httpStatus){
        this.httpStatus = httpStatus;
    }
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

}
