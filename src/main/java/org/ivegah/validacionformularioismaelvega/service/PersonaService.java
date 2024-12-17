package org.ivegah.validacionformularioismaelvega.service;

import org.ivegah.validacionformularioismaelvega.model.Persona;

import java.util.List;

public interface PersonaService {

    List<Persona> devuelveTodasPersonas();
    Persona devuelvePersonaPorId(long id);
    void creaPersona(Persona persona);
    void actualizaPersona(Persona persona);
    void eliminaPersona(long id);
    void eliminaTodaPersona();

}
