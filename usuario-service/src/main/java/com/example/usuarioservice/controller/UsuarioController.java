package com.example.usuarioservice.controller;

import com.example.usuarioservice.entidades.Usuario;
import com.example.usuarioservice.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Locale;

@RestController
public class UsuarioController {
 /*   @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/usuarios")
    public List <Usuario> usuarios(){
        return usuarioService.listarUsuarios();
    }

    @GetMapping("/clientes/{id}")
    public Usuario buscarPorId(@PathVariable Long id) {

        return usuarioService.encontrarUsuarioPorId(id);
    }

    @RequestMapping(value = "/usuarios", method = RequestMethod.POST, consumes = { "application/json" })
    public ResponseEntity<Usuario> crearCliente(@RequestBody Usuario usuario) {
        usuarioService.crearUsuario(usuario);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/usuarios/devolver")
    public ResponseEntity<Usuario> devolverNuevoCliente(@RequestBody Usuario usuario) {
        return new ResponseEntity<>(usuarioService.devolverNuevoCliente(usuario), HttpStatus.OK);
    }*/
}
