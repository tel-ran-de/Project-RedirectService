package de.telran.projectredirectservice.validator;

import java.lang.annotation.*;
import javax.validation.Constraint;
import javax.validation.Payload;

import static java.lang.annotation.ElementType.*;

@Target(TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ExpirationDateConstrainValidator.class)
@Documented
public @interface ValidatorExpirationDate {
    String message() default "wrong date. Date in the past";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
