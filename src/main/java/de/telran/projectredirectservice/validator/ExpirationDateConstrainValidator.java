package de.telran.projectredirectservice.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDateTime;

public class ExpirationDateConstrainValidator implements ConstraintValidator<ValidatorExpirationDate, LocalDateTime> {
    @Override
    public void initialize(ValidatorExpirationDate constraintAnnotation) {

    }

    @Override
    public boolean isValid(LocalDateTime date, ConstraintValidatorContext context) {
        if ( date == null ) {
            return true;
        }
        return date.isAfter(LocalDateTime.now());
    }
}
