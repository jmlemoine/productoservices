package com.example.usuarioservice.repositorios;

import com.example.usuarioservice.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {
    Cliente findClienteById(long id);
}
