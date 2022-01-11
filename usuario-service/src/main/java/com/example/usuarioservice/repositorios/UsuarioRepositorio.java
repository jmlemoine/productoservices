package com.example.usuarioservice.repositorios;

import com.example.usuarioservice.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, String> {

    Usuario findByUsername(String username);
    Usuario findByCorreo(String correo);
}
