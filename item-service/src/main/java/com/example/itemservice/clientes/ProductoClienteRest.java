package com.example.itemservice.clientes;

import com.example.itemservice.models.Producto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//Application.properties de Productos para indicar de donde trabaja
@FeignClient(name = "servicio-productos")
public interface ProductoClienteRest {

    @GetMapping("/listar")
    public List<Producto> listar();

    @GetMapping("/listar/{id}")
    public Producto detalle(@PathVariable Long id);
}
