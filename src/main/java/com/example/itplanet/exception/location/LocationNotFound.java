package com.example.itplanet.exception.location;

import org.springframework.http.HttpStatus;

public class LocationNotFound extends RuntimeException{

    private HttpStatus httpStatus;
    public LocationNotFound(HttpStatus httpStatus){
        this.httpStatus = httpStatus;
    }
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

}
