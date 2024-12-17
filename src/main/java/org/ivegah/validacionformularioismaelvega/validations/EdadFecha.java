package org.ivegah.validacionformularioismaelvega.validations;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ TYPE }) //A nivel de atributo (Campo) // TYPE para clase
@Retention(RUNTIME) //Se valida en tiempo de ejecucion
@Constraint(validatedBy = EdadFechaValidator.class)
@Documented
public @interface EdadFecha {

    String message() default "{formulario.edadFecha}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
