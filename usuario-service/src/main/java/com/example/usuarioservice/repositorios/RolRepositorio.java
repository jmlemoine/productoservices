package com.example.usuarioservice.repositorios;

import com.example.usuarioservice.entidades.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepositorio extends JpaRepository<Rol, String> {
    Rol findByRole (String role);
}
