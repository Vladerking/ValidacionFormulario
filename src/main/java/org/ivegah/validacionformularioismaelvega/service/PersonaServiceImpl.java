package org.ivegah.validacionformularioismaelvega.service;

import org.ivegah.validacionformularioismaelvega.exceptions.PersonaNoEncontradaException;
import org.ivegah.validacionformularioismaelvega.exceptions.PersonaYaExisteException;
import org.ivegah.validacionformularioismaelvega.model.DatosPersonas;
import org.ivegah.validacionformularioismaelvega.model.Persona;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Override
    public List<Persona> devuelveTodasPersonas() {
        return DatosPersonas.getListaPersonas();
    }

    @Override
    public Persona devuelvePersonaPorId(long id) {
        Persona personaAux = DatosPersonas.getPersonaPorId(id);

        if (personaAux == null) {
            throw new PersonaNoEncontradaException("La persona con id: " + id + " no existe");
        }
        return personaAux;
    }

    @Override
    public void creaPersona(Persona persona) {

        if (!DatosPersonas.addPersona(persona)) {
            throw new PersonaYaExisteException("La persona ya existe");
        }
        DatosPersonas.addPersona(persona);

    }

    @Override
    public void actualizaPersona(Persona persona) {

        if (!DatosPersonas.actualizarPersona(persona)) {
            throw new PersonaNoEncontradaException("La persona no existe");
        }
        DatosPersonas.actualizarPersona(persona);
    }

    @Override
    public void eliminaPersona(long id) {
        if (!DatosPersonas.removerPersonaPorId(id)) {
            throw new PersonaNoEncontradaException("La persona con id: " + id + " no existe");
        }
        DatosPersonas.removerPersonaPorId(id);
    }

    @Override
    public void eliminaTodaPersona() {
        DatosPersonas.removeTodasPersonas();
    }
}
