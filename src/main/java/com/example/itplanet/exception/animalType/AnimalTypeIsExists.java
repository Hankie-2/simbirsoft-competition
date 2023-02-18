package com.example.itplanet.exception.animalType;

import org.springframework.http.HttpStatus;

public class AnimalTypeIsExists extends RuntimeException{
    private HttpStatus httpStatus;
    public AnimalTypeIsExists(HttpStatus httpStatus){
        this.httpStatus = httpStatus;
    }
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
