package org.ivegah.validacionformularioismaelvega.model;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Colecciones {

    private static Map<String, String> mapaGeneros;

    static {
        mapaGeneros = new TreeMap<>();
        mapaGeneros.put("F", "Femenino");
        mapaGeneros.put("M", "Masculino");
        mapaGeneros.put("O", "Otros");
    }

    private static Map<String, String> mapaAficiones;

    static {
        mapaAficiones = new TreeMap<>();
        mapaAficiones.put("D", "Deporte");
        mapaAficiones.put("L", "Lectura");
        mapaAficiones.put("P", "Pintura");
        mapaAficiones.put("V", "Viajes");
    }

    private static Map<String, Pais> mapaPais;

    static {
        mapaPais = new TreeMap<>();
        Pais españa=
        mapaPais.put("es",new Pais("España","Castellano","34",true,"espania.jpg"));
        mapaPais.put("fr",new Pais("Francia", "Francés", "33", false, "francia.jpg"));
        mapaPais.put("it",new Pais("Italia", "Italiano", "39", false, "italia.jpg"));
        mapaPais.put("pt",new Pais("Portugal", "Portugués", "351", false, "portugal.jpg"));
        mapaPais.put("en",new Pais("Reino unido", "Inglés", "44", true, "reino_unido.jpg"));


    }

    private static Map<String, String> mapaMusica;

    static {
        mapaMusica = new TreeMap<>();
        mapaMusica.put("E", "Electrónica");
        mapaMusica.put("F", "Funky");
        mapaMusica.put("N", "New age");
        mapaMusica.put("P", "Pop");
        mapaMusica.put("R", "Rock");
    }


    public static Map<String, String> getMapaGeneros() {
        return mapaGeneros;
    }

    public static Map<String, String> getMapaAficiones() {
        return mapaAficiones;
    }

    public static Map<String, Pais> getMapaPaises() {
        return mapaPais;
    }

    public static Map<String, String> getMapaMusica() {
        return mapaMusica;
    }
}