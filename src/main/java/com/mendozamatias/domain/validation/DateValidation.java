package com.mendozamatias.domain.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DateValidations.class)
public @interface DateValidation {
    String message() default "El dia no puede ser domingo";
    Class<?>[] groups() default {};
    Class <? extends Payload>[] payload() default {};
}
