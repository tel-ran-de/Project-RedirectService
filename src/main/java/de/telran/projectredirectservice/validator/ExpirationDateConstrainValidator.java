package de.telran.projectredirectservice.validator;

import de.telran.projectredirectservice.dto.LongUrlDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDateTime;

public class ExpirationDateConstrainValidator implements ConstraintValidator<ValidatorExpirationDate, LongUrlDto> {
    @Override
    public void initialize(ValidatorExpirationDate constraintAnnotation) {

    }

    @Override
    public boolean isValid(LongUrlDto longUrlDto, ConstraintValidatorContext context) {
        if ( longUrlDto.getExpirationDate() == null ) {
            return true;
        }
        return longUrlDto.getExpirationDate().isAfter(LocalDateTime.now());
    }
}
