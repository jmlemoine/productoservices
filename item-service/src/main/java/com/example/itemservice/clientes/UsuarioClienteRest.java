package com.example.itemservice.clientes;

import com.example.itemservice.models.Producto;
import com.example.itemservice.models.Usuario;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "servicio-usuarios")
public interface UsuarioClienteRest {

    @GetMapping("/usuarios")
    public List<Usuario> listar();
}
