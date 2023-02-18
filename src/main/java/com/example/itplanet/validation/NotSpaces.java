package com.example.itplanet.validation;

import com.example.itplanet.validation.validator.SpaceValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = SpaceValidator.class)
public @interface NotSpaces {

    String message() default "{com.example.itplanet.validation.NotSpaces.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
