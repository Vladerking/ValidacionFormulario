package org.ivegah.validacionformularioismaelvega.validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.ivegah.validacionformularioismaelvega.model.DatosFormulario;

import java.time.LocalDate;
import java.time.Period;


public class EdadFechaValidator implements ConstraintValidator<EdadFecha, DatosFormulario> {


    @Override
    public boolean isValid(DatosFormulario datosFormulario, ConstraintValidatorContext context) {
        LocalDate fechaNacimiento = datosFormulario.getFechaNacimiento();
        Integer edad = datosFormulario.getEdad();

        if (datosFormulario.getEdad() == null) {
            return false;
        }

//        Intento que si esta en blanco no salte el error, pero no lo consigo y salta igualmente
        String strEdad = String.valueOf(edad);
        int edadCalculada = Period.between(fechaNacimiento, LocalDate.now()).getYears();
        if (strEdad.isBlank() || edad == edadCalculada) {
            return true;
        }

        return false;
    }
}
