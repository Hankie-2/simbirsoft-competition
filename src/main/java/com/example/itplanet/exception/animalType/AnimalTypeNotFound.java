package com.example.itplanet.exception.animalType;

import org.springframework.http.HttpStatus;

public class AnimalTypeNotFound extends RuntimeException{

    private HttpStatus httpStatus;
    public AnimalTypeNotFound(HttpStatus httpStatus){
        this.httpStatus = httpStatus;
    }
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

}
