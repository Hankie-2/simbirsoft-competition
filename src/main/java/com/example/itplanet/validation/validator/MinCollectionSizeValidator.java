package com.example.itplanet.validation.validator;

import com.example.itplanet.validation.MinCollectionSize;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class MinCollectionSizeValidator implements ConstraintValidator<MinCollectionSize, List<Object>> {
    @Override
    public boolean isValid(List<Object> list, ConstraintValidatorContext constraintValidatorContext) {
        return list.size()>=1;
    }
}
