package com.example.itplanet.exception.animal;

import org.springframework.http.HttpStatus;

public class AnimalNotFound extends RuntimeException {
    private HttpStatus httpStatus;
    public AnimalNotFound(HttpStatus httpStatus){
        this.httpStatus = httpStatus;
    }
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
