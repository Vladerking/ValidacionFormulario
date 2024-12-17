package org.ivegah.validacionformularioismaelvega.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Pais {
    private String pais;
    private String idioma;
    private String prefijoTelefonico;
    private boolean muestraIdioma;
    private String nombreArchivoBandera;

}
