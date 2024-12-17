package org.ivegah.validacionformularioismaelvega.model;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
//@AllArgsConstructor
@Data //Getters + Setters + ToString + EqualsAndHashCode
public class Persona {
    private Long id;
    private String nombre;
    private LocalDate fechaNacimiento;
    private Float peso;

    public Persona(Long id, String nombre, LocalDate fechaNacimiento, Float peso) {
        this.id = id;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.peso = peso;
    }

}
