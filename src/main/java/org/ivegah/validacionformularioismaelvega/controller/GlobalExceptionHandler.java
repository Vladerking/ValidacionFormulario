package org.ivegah.validacionformularioismaelvega.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

//    INTENTO DE CONTROLAR UNA EXCEPCION GLOBAL //Revise documentacion pero no consegui que funcionase
    @ExceptionHandler(Exception.class)
    public String handleGenericException(Exception ex, Model model) {
        // Puedes agregar el mensaje de error al modelo
        model.addAttribute("errorApp", "Error en el funcionamiento de la aplicación" + ex.getMessage());

        // Retorna la redirección
        return "redirect:devuelve-formulario";
    }
}
