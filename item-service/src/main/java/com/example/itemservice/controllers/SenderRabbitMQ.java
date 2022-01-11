package com.example.itemservice.controllers;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;


public class SenderRabbitMQ {
    @Autowired
    private RabbitTemplate template;

    @Autowired
    private Queue queue;

    public void send(String message) {
        this.template.convertAndSend(queue.getName(), message);
        System.out.println(" [x] Sent '" + message + "'");
    }
}