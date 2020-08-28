package com.example.usuarioservice;

import com.example.usuarioservice.services.SeguridadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.event.EventListener;

@EnableEurekaClient
@SpringBootApplication
public class UsuarioServiceApplication {

    @Autowired
    private SeguridadService seguridadService;

    public static void main(String[] args) {
        SpringApplication.run(UsuarioServiceApplication.class, args);
    }
    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStartup() {
        //Creando usuario administrador es la primera url de entrada
        seguridadService.crearUsuarioAdmin();
        System.out.println("Corriendo Usuario");
    }

}
