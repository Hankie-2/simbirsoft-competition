package com.example.itplanet.validation.validator;

import com.example.itplanet.model.enums.AnimalGender;
import com.example.itplanet.validation.NotGender;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NotGenderValidator implements ConstraintValidator<NotGender, AnimalGender> {
    @Override
    public boolean isValid(AnimalGender animalGender, ConstraintValidatorContext constraintValidatorContext) {
        return animalGender == AnimalGender.MALE || animalGender == AnimalGender.FEMALE || animalGender == AnimalGender.OTHER;
    }
}
