package org.chubaka.service;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = LoginConstraintValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginValidation {

    //define default value
    String value() default "SUPER";

    //define default error message
    String message() default "must start with SUPER";

    //define defaults groups
    Class<?>[] groups() default {};

    //define default payloads
    Class<? extends Payload>[] payload() default {};
}
