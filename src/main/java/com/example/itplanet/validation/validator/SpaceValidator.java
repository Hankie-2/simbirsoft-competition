package com.example.itplanet.validation.validator;

import com.example.itplanet.validation.NotSpaces;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class SpaceValidator implements ConstraintValidator<NotSpaces,String> {
    @Override
    public boolean isValid(String text, ConstraintValidatorContext constraintValidatorContext) {
        for(char ch:text.toCharArray()){
            if(ch == ' ') return false;
        }
        return true;
    }
}
