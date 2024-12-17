package org.ivegah.validacionformularioismaelvega;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ivegah.validacionformularioismaelvega.model.Persona;

import java.time.LocalDate;
import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Pruebas {
    public static void main(String[] args) {
        Map<Integer,Integer> mapaEnteros = Stream.of(
                        new AbstractMap.SimpleImmutableEntry<>(3,2),
                        new AbstractMap.SimpleImmutableEntry<>(-8,1),
                        new AbstractMap.SimpleImmutableEntry<>(-7,-4),
                        new AbstractMap.SimpleImmutableEntry<>(6,9))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        List<Punto> listaPuntos = mapaEnteros.entrySet()
                .stream()
                .map(p-> new Punto(p.getKey(),p.getValue())).toList();

        listaPuntos.forEach(p-> System.out.println(p));

    }


}

