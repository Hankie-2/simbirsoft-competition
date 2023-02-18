package com.example.itplanet.exception.location;

import org.springframework.http.HttpStatus;

public class LocationIsExists extends RuntimeException{
    private HttpStatus httpStatus;
    public LocationIsExists(HttpStatus httpStatus){
        this.httpStatus = httpStatus;
    }
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
