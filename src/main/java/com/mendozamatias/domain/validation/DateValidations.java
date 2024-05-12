package com.mendozamatias.domain.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class DateValidations implements ConstraintValidator<DateValidation, LocalDate> {
    @Override
    public void initialize(DateValidation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(LocalDate localDate, ConstraintValidatorContext constraintValidatorContext) {
        boolean noEsDomingo = localDate.getDayOfWeek() != DayOfWeek.SUNDAY; //Obtiene el dia de la semana y compara que este sea distinto a domingo
        boolean noEsUnAnioAnterior = localDate.getYear() != LocalDate.now().getYear() -1; //Obtiene el año y compara que este sea distinto a el año anterior
        return noEsDomingo && noEsUnAnioAnterior;
    }
}
