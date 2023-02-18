package com.example.itplanet.validation;

import com.example.itplanet.validation.validator.MinCollectionSizeValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = MinCollectionSizeValidator.class)
public @interface MinCollectionSize {
    String message() default "{com.example.itplanet.validation.MinCollectionSize.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
