package org.ivegah.validacionformularioismaelvega.service;

import org.ivegah.validacionformularioismaelvega.exceptions.PersonaNoEncontradaException;
import org.ivegah.validacionformularioismaelvega.exceptions.PersonaYaExisteException;
import org.ivegah.validacionformularioismaelvega.model.Persona;
import org.ivegah.validacionformularioismaelvega.service.PersonaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class PersonaServiceImplTest {

    /*@InjectMocks
    private PersonaService personaServicio;*/

    private PersonaService personaServicio = new PersonaServiceImpl();
    private long idEmpleadoNoExiste = 3L; //Persona no existe
    private long idEmpleadoExiste = 1L; //Persona si existe

    @Test
    public void test_devuelvePersonaPorId() {
//        PersonaService personaServicio = new PersonaServiceImpl();
     /*   long idEmpleadoNoExiste = 3L; //Persona no existe
        long idEmpleadoExiste = 1L; //Persona si existe*/

        assertThrows(PersonaNoEncontradaException.class, () -> {
            personaServicio.devuelvePersonaPorId(idEmpleadoNoExiste);
        });

        assertDoesNotThrow(() -> {
            personaServicio.devuelvePersonaPorId(idEmpleadoExiste);
        });

    }


    @Test
    public void test_devuelveTodasPersonas() {
        List<Persona> listaPruebas = personaServicio.devuelveTodasPersonas();

        assertEquals(2, listaPruebas.size());
    }

    @Test
    public void test_crearPersona() {
        Persona personaPruebaExiste = new Persona(idEmpleadoExiste, "Pepe", LocalDate.of(2000, 1, 2), 72.36F);
        Persona personaPruebaNoExiste = new Persona(idEmpleadoNoExiste, "Lolo", LocalDate.of(1996, 5, 6), 79.62F);

        assertThrows(PersonaYaExisteException.class, () -> {
            personaServicio.creaPersona(personaPruebaExiste);
        });

        assertDoesNotThrow(() -> {
            personaServicio.creaPersona(personaPruebaNoExiste);
        });
    }

    @Test
    public void test_actualizarPersona() {
        Persona personaPruebaExiste = new Persona(idEmpleadoExiste, "Pepe", LocalDate.of(2000, 1, 2), 72.36F);
        Persona personaPruebaNoExiste = new Persona(idEmpleadoNoExiste, "Lolo", LocalDate.of(1996, 5, 6), 79.62F);

        assertThrows(PersonaNoEncontradaException.class, () -> {
            personaServicio.actualizaPersona(personaPruebaNoExiste);
        });

        assertDoesNotThrow(() -> {
            personaServicio.actualizaPersona(personaPruebaExiste);
        });

    }

    @Test
    public void test_eliminaPersona() {

        assertThrows(PersonaNoEncontradaException.class, () -> {
            personaServicio.eliminaPersona(idEmpleadoNoExiste);
        });

        assertDoesNotThrow(() -> {
            personaServicio.eliminaPersona(idEmpleadoExiste);
        });

    }

    @Test
    public void test_eliminaTodasPersonas() {
        personaServicio.eliminaTodaPersona();

        List<Persona> listaPruebas = personaServicio.devuelveTodasPersonas();

        assertEquals(0, listaPruebas.size());
    }


}
