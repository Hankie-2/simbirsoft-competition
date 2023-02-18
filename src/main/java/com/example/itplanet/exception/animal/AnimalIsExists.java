package com.example.itplanet.exception.animal;

import org.springframework.http.HttpStatus;

public class AnimalIsExists extends RuntimeException{
    private HttpStatus httpStatus;
    public AnimalIsExists(HttpStatus httpStatus){
        this.httpStatus = httpStatus;
    }
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
