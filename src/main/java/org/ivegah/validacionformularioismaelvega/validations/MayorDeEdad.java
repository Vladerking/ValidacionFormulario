package org.ivegah.validacionformularioismaelvega.validations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ FIELD }) //A nivel de atributo (Campo) // TYPE para clase
@Retention(RUNTIME) //Se valida en tiempo de ejecucion
@Constraint(validatedBy = MayorDeEdadValidator.class)
@Documented
public @interface MayorDeEdad {
    String message() default "Debe ser mayor de 18 años";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}

