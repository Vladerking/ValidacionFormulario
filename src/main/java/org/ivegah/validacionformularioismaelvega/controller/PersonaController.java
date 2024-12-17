package org.ivegah.validacionformularioismaelvega.controller;

import org.ivegah.validacionformularioismaelvega.model.Persona;
import org.ivegah.validacionformularioismaelvega.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("persona")
public class PersonaController {
    private final PersonaService personaServicio;

    public PersonaController(PersonaService personaServicio) {
        this.personaServicio = personaServicio;
    }

    @GetMapping
    @ResponseBody
    public List<Persona> devuelveTodasPersonas(){
        return personaServicio.devuelveTodasPersonas();
    }
}
