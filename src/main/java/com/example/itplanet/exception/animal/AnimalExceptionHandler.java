package com.example.itplanet.exception.animal;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AnimalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AnimalIsExists.class)
    public ResponseEntity<?> animalIsExistsException(AnimalIsExists e){
        return new ResponseEntity<>(e.getHttpStatus());
    }

    @ExceptionHandler(AnimalNotFound.class)
    public ResponseEntity<?> animalNotFoundException(AnimalNotFound e){
        return new ResponseEntity<>(e.getHttpStatus());
    }

}
