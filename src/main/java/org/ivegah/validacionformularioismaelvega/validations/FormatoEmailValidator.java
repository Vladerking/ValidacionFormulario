package org.ivegah.validacionformularioismaelvega.validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class FormatoEmailValidator implements ConstraintValidator<FormatoEmail, String> {

    private static final String EMAIL_PATTERN =
            "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        if (email == null || email.isEmpty()) {
            return true; //@NotNull se encargara de esta validacion
        }
        return email.matches(EMAIL_PATTERN);
    }
}
