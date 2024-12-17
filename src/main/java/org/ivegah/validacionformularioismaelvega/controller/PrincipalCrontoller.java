package org.ivegah.validacionformularioismaelvega.controller;

//import model.Colecciones;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.ivegah.validacionformularioismaelvega.model.Colecciones;
import org.ivegah.validacionformularioismaelvega.model.DatosFormulario;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
// Para acceder a los endpoints hay que indicar que estan dentro de formulario
//Ejemplo: http://localhost:8080/formulario/devuelve-formulario
@RequestMapping("formulario")
public class PrincipalCrontoller {
    //Declaracion atributos de forma global
    @ModelAttribute
    private void añadeAtributosModelo(Model modelo, HttpServletRequest peticion) {
        modelo.addAttribute("generos", Colecciones.getMapaGeneros());
        modelo.addAttribute("aficiones", Colecciones.getMapaAficiones());
        modelo.addAttribute("paises", Colecciones.getMapaPaises());
        modelo.addAttribute("musicas", Colecciones.getMapaMusica());

        // Dirección IP del cliente
        String ipCliente = peticion.getRemoteAddr();
        // Navegador
        String navegador = peticion.getHeader("User-Agent");
        // Sistema operativo -- No consigo que muestre nada
        String sistemaOperativo = peticion.getHeader("os.name");
        // Motor de renderización -- No consigo que muestre nada
        String motorRenderizacion = "?";
        // Nombre de host
        String host = peticion.getHeader("Host");
        // Idioma y locale
        String idioma = peticion.getLocale().toString();

        //        CABECERA
        modelo.addAttribute("ip", ipCliente);
        modelo.addAttribute("navegador", navegador);
        modelo.addAttribute("motor", motorRenderizacion);
        modelo.addAttribute("so", sistemaOperativo);
        modelo.addAttribute("idioma", idioma);
        modelo.addAttribute("host", host);

    }

    @GetMapping("devuelve-formulario")
    public String devuelveFormulario(
            Model modelo,
            @ModelAttribute ("datosFormulario") DatosFormulario datosFormulario) {

        modelo.addAttribute("titulo", "Original");
        modelo.addAttribute("iteraciones", "1");

        return "/formulario/formulario";
    }


    @PostMapping("recibe-parametros")
    public String recibeParametrosYRepinta(
            Model modelo,
            @RequestParam(required = false) Integer iteraciones,
            @RequestParam(required = false) Map<String, String> todosParametros,
            @RequestParam(name = "imagen.x", required = false) String imagenEnviarX,
            @RequestParam(name = "imagen.y", required = false) String imagenEnviarY,
            //@Valid para que haga las validaciones @ModelAttribute para pasarle a la vista el objeto
            @Valid @ModelAttribute("datosFormulario") DatosFormulario datosFormulario,
            //Mapa que se construye con los errores de las validacion
            BindingResult resultadoValidacion) {

//        Pasamos las variables que no recibimos en el POJO
        modelo.addAttribute("titulo", "Repintado");
        modelo.addAttribute("iteraciones", iteraciones + 1);
        modelo.addAttribute("total_parametros", todosParametros.size());
        modelo.addAttribute("imagen_enviar_x", imagenEnviarX);
        modelo.addAttribute("imagen_enviar_y", imagenEnviarY);


        if (resultadoValidacion.hasErrors()) { //si hay errores
            modelo.addAttribute("mensajeNOK", "ALERTA: Formulario con errores");
            return "/formulario/formulario";
        }
        //si no hay errores
        modelo.addAttribute("mensajeOK", "ALELUYA: Formulario sin errores");
        return "/formulario/formulario";
    }

}
