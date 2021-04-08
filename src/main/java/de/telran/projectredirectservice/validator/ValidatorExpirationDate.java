package de.telran.projectredirectservice.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = ExpirationDateConstrainValidator.class)
@Target({ METHOD, FIELD,  PARAMETER })
@Retention(RUNTIME)
@Documented
public @interface ValidatorExpirationDate {
    String message() default "wrong date. Date in the past";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
