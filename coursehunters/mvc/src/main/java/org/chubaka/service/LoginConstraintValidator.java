package org.chubaka.service;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class LoginConstraintValidator implements ConstraintValidator<LoginValidation, String> {

    private String loginPrefix;

    @Override
    public void initialize(LoginValidation constraintAnnotation) {
        loginPrefix = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String login, ConstraintValidatorContext constraintValidatorContext) {
        return login != null ? login.startsWith(loginPrefix) : true;
    }
}
