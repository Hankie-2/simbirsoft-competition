package com.example.itplanet.exception.location;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class LocationExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(LocationNotFound.class)
    public ResponseEntity<?> locationNotFoundException(LocationNotFound e){
        return new ResponseEntity<>(e.getHttpStatus());
    }

    @ExceptionHandler(LocationIsExists.class)
    public ResponseEntity<?> locationIsExistsException(LocationIsExists e){
        return new ResponseEntity<>(e.getHttpStatus());
    }
}
