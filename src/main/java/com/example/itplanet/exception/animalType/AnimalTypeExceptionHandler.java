package com.example.itplanet.exception.animalType;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AnimalTypeExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AnimalTypeNotFound.class)
    public ResponseEntity<?> animalTypeNotFound(AnimalTypeNotFound e){
        return new ResponseEntity<>(e.getHttpStatus());
    }

    @ExceptionHandler(AnimalTypeIsExists.class)
    public ResponseEntity<?> animalTypeIsExists(AnimalTypeIsExists e){
        return new ResponseEntity<>(e.getHttpStatus());
    }

}
