package com.example.itplanet.validation;

import com.example.itplanet.validation.validator.ElementOfCollectionNotNullValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = ElementOfCollectionNotNullValidator.class)
public @interface ElementOfCollectionNotNull {
    String message() default "{com.example.itplanet.validation.ElementOfCollectionNotNull.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
