package org.ivegah.validacionformularioismaelvega.validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.ivegah.validacionformularioismaelvega.model.DatosFormulario;

public class ClaveConfirmadaValidator implements ConstraintValidator<ClaveConfirmada, DatosFormulario> {
    @Override
    public boolean isValid(DatosFormulario datosFormulario, ConstraintValidatorContext constraintValidatorContext) {

        if(datosFormulario.getClave()==null){
            return false;
        }
        if(datosFormulario.getClave().equals(datosFormulario.getConfirmarClave())){
            return true;
        }
        return false;
    }
}
