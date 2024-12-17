package org.ivegah.validacionformularioismaelvega.exceptions;

public class PersonaYaExisteException extends RuntimeException {
     public PersonaYaExisteException(String mensaje) {
         super(mensaje);
     }
}
