package org.ivegah.validacionformularioismaelvega;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ValidacionFormularioIsmaelVegaApplication extends SpringBootServletInitializer { //para WAR

    public static void main(String[] args) {
        SpringApplication.run(ValidacionFormularioIsmaelVegaApplication.class, args);
    }

}
