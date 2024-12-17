package org.ivegah.validacionformularioismaelvega.model;

import jakarta.validation.constraints.*;
import lombok.*;
import org.ivegah.validacionformularioismaelvega.validations.ClaveConfirmada;
import org.ivegah.validacionformularioismaelvega.validations.EdadFecha;
import org.ivegah.validacionformularioismaelvega.validations.FormatoEmail;
import org.ivegah.validacionformularioismaelvega.validations.MayorDeEdad;
import org.springframework.format.annotation.DateTimeFormat;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@EdadFecha
@ClaveConfirmada
public class DatosFormulario {

    @NotNull
    @NotBlank(message = "{formulario.nombre.notblank}") //Mensaje generico de jakarta
    private String nombre = "Lola";

    @NotNull
    @NotBlank(message = "{formulario.clave.notblank}")
    @Size(min = 6, max = 12, message = "{formulario.clave.size}")
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!#$%&]).+$", message = "{formulario.clave.pattern}")
    private String clave;


    @NotNull
    @NotBlank(message = "{formulario.clave.notblank}")
    @Size(min = 6, max = 12, message = "{formulario.clave.size}")
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!#$%&]).+$", message = "{formulario.clave.pattern}")
    private String confirmarClave;

    @NotNull
    @Pattern(regexp = "[FMO]", message = "{formulario.generoSeleccionado.pattern}" )
    private String generoSeleccionado;

    @NotNull
    @Pattern(regexp = "es|fr|it|pt|en", message = "{formulario.paisSeleccionado.pattern}")
    private String paisSeleccionado = "pt";


    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Past(message = "{formulario.fecha_nace.past}")
    @MayorDeEdad(message = "{formulario.fecha_nace.valido}")
    private LocalDate fechaNacimiento;

    @NotNull
    @Min(value = 18, message = "{formulario.edad.min}")
    private Integer edad;

    @NotNull
    @Digits(integer = 3, fraction = 2, message = "{formulario.peso.digits}")
    private Float peso;

    @NotNull
    @Pattern(regexp = "es|fr|it|pt|en", message = "{formulario.prefijoTelefonicoPais.pattern}")
    private String prefijoTelefonicoPais = "fr";

    @NotNull
    @Pattern(regexp = "^\\d{9}$", message = "{formulario.telefono.pattern}")
    private String telefono;

    @NotNull
    @FormatoEmail (message = "{formulario.email.valido}")
    private String email;

    @NotNull
    private String url;

    @NotNull
    @Pattern(regexp = "^(?i)(|.*\\.(pdf|jpg|jpeg|gif))$", message = "{formulario.archivos.pattern}")
    private String archivos;


    @NotEmpty
    @Size(min = 1, message = "{formulario.musicasSeleccionadas.size}")
    private List<String> musicasSeleccionadas = musicasDefecto();

    @Size(min = 2, message = "{formulario.aficionesSeleccionadas.size}")
    private List<String> aficionesSeleccionadas = aficionesDefecto();

    @NotNull
    private String comentarios;

    @NotNull
    private Boolean licencia;


    public List<String> musicasDefecto() {
        musicasSeleccionadas = new ArrayList<>();
        musicasSeleccionadas.add("F");
        musicasSeleccionadas.add("R");
        return musicasSeleccionadas;
    }

    public List<String> aficionesDefecto() {
        aficionesSeleccionadas = new ArrayList<>();
        aficionesSeleccionadas.add("D");
        aficionesSeleccionadas.add("P");
        aficionesSeleccionadas.add("V");
        return aficionesSeleccionadas;
    }


}
