package com.example.itemservice.controllers;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ColaConfiguracion {
    @Bean
    public Queue envioMensaje() {
        return new Queue("email");
    }

    @Bean
    public SenderRabbitMQ sender() {
        return new SenderRabbitMQ();
    }
}