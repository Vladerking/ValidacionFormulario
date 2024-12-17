package org.ivegah.validacionformularioismaelvega.model;

import org.ivegah.validacionformularioismaelvega.service.PersonaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
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
public class DatosPersonasTest {

    /*@InjectMocks
    private PersonaService personaServicio;*/

    /*@Mock Capa superior del modelo
    private EmployeeRepository employeeRepository;*/

    @Test
    public void test_devuelveTodasPersonas() {
        List<Persona> listaPruebas = DatosPersonas.getListaPersonas();
        assertEquals(2, listaPruebas.size());
    }

    @Test
    public void test_GetPersonaPorId_Encontrado() {
        // Arrange
        long idEmpleado = 1L;
        Persona personaPrueba = new Persona(1L, "Pepe", LocalDate.of(2000, 1, 2), 72.36F);

        // Mock the behavior of the repository to return the mock employee
        // Mockito.when(employeeRepository.findById(employeeId)).thenReturn(Optional.of(mockEmployee));

        // Act
        Persona personaRecuperada = DatosPersonas.getPersonaPorId(idEmpleado);
        //Employee result = employeeService.getEmployeeById(employeeId);

        // Assert
        assertNotNull(personaRecuperada);
        assertEquals(idEmpleado, personaRecuperada.getId());
        assertEquals(personaPrueba.getNombre(), personaRecuperada.getNombre());
        assertEquals(personaPrueba.getFechaNacimiento(), personaRecuperada.getFechaNacimiento());
//        assertEquals(personaPrueba,personaRecuperada);
    }

    @Test
    public void test_GetPersonaPorId_NoEncontrado() {
        // Arrange
        long idEmpleado = 3L; //id que no existe en la listaPersonas

//        Persona personaPrueba = new Persona(idEmpleado, "Lolo", LocalDate.of(1996, 5, 6), 79.62F);

        Persona personaRecuperada = DatosPersonas.getPersonaPorId(idEmpleado);


        // Assert
        assertNull(personaRecuperada);

    }

    @Test
    public void test_addPersona_NoExiste() {
        Long idEmpleado = 3L; //NO EXISTE
        Persona personaPrueba = new Persona(idEmpleado, "Lolo", LocalDate.of(1996, 5, 6), 79.62F);

        assertTrue(DatosPersonas.addPersona(personaPrueba));
    }

    @Test
    public void test_addPersona_Existe() {
        Long idEmpleado = 1L;
        Persona personaPrueba = new Persona(idEmpleado, "Pepe", LocalDate.of(2000, 1, 2), 72.36F);


        assertFalse(DatosPersonas.addPersona(personaPrueba));
    }

    @Test
    public void test_removeTodasPersonas() {
        DatosPersonas.removeTodasPersonas();
        List<Persona> listaPersonasPrueba = DatosPersonas.getListaPersonas();

        assertTrue(listaPersonasPrueba.isEmpty());

    }

    @Test
    public void test_removerPersonaPorId() {
        Long idEmpleadoExiste = 1L;
        Long idEmpleadoNoExiste = 5L;

        assertTrue(DatosPersonas.removerPersonaPorId(idEmpleadoExiste));

//        List<Persona> listaPersonasPrueba=DatosPersonas.getListaPersonas();

//        assertEquals(1, listaPersonasPrueba.size());
        assertFalse(DatosPersonas.removerPersonaPorId(idEmpleadoNoExiste));
    }

    @Test
    public void actualizarPersona() {
        Long idEmpleadoExiste = 1L;
        Long idEmpleadoNoExiste = 5L;

        Persona personaExiste = new Persona(idEmpleadoExiste, "Lolo", LocalDate.of(1996, 5, 6), 79.62F);
        Persona personaNoExiste = new Persona(idEmpleadoNoExiste, "Lolo", LocalDate.of(1996, 5, 6), 79.62F);

        assertTrue(DatosPersonas.actualizarPersona(personaExiste));
        assertFalse(DatosPersonas.actualizarPersona(personaNoExiste));

    }

}

