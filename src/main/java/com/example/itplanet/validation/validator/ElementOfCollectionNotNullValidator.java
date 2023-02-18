package com.example.itplanet.validation.validator;

import com.example.itplanet.validation.ElementOfCollectionNotNull;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class ElementOfCollectionNotNullValidator implements ConstraintValidator<ElementOfCollectionNotNull, List<Object>> {
    @Override
    public boolean isValid(List<Object> objects, ConstraintValidatorContext constraintValidatorContext) {
        for(Object obj:objects){
            if(obj == null){
                return false;
            }
        }
        return true;
    }
}
