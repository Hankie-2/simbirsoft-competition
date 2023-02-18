package com.example.itplanet.validation;

import com.example.itplanet.validation.validator.NotGenderValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = NotGenderValidator.class)
public @interface NotGender {
    String message() default "{com.example.itplanet.validation.NotGender.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
