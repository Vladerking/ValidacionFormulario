package org.ivegah.validacionformularioismaelvega.model;

import lombok.Getter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DatosPersonas {
    //    @Getter
    private static List<Persona> listaPersonas =
            //Sintaxis 1
       /*     new ArrayList<Persona>(){{
                add(new Persona(1L,"Pepe", LocalDate.of(2000,1,2),72.36F));
                add(new Persona(2L,"Charo", LocalDate.of(2000,1,2),72.36F));
    }};*/
            //Sintaxis 2: genera objeto inmutable lo cual no podriamos realizar operaciones de modificacion
   /* Arrays.asList(
            new Persona(1L,"Pepe", LocalDate.of(2000,1,2),72.36F),
            new Persona(2L,"Charo", LocalDate.of(2000,1,2),72.36F)
            );*/

            //Sintaxis 3: genera objeto mutable
            Stream.of(
                    new Persona(1L, "Pepe", LocalDate.of(2000, 1, 2), 72.36F),
                    new Persona(2L, "Charo", LocalDate.of(2000, 1, 2), 72.36F)
            ).collect(Collectors.toList());

    //Sintaxis 4
  /*  static {

    }*/

    public static List<Persona> getListaPersonas() {
        return listaPersonas;
    }

    public static Persona getPersonaPorId(long id) {
        return listaPersonas
                .stream()
                .filter(persona -> persona.getId() == id) //devuelve una lista
                .findFirst()
                .orElse(null);
        /* for (Persona persona : listaPersonas) {
            if (persona.getId().equals(id)) {
                return persona;
            }
        }
        return null;*/
    }

    public static void removeTodasPersonas() {
        listaPersonas.clear();
    }

    public static boolean removerPersonaPorId(long id) {
        return listaPersonas.removeIf(persona -> persona.getId() == id);

    }

    public static boolean addPersona(Persona persona) {
        if (!listaPersonas.stream()
                .anyMatch(p -> p.getId().equals(persona.getId()))) {
            return listaPersonas.add(persona);
        }
        return false;
    }

    public static boolean actualizarPersona(Persona persona) {
        Persona personaModificar = getPersonaPorId(persona.getId());
        if (personaModificar != null) {
            removerPersonaPorId(personaModificar.getId());
            return listaPersonas.add(persona);
        }
        return false;
    }


}
