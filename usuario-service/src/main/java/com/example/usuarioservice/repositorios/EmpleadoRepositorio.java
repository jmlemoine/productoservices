package com.example.usuarioservice.repositorios;

import com.example.usuarioservice.entidades.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepositorio extends JpaRepository<Empleado, Long> {
    Empleado findEmpleadoById (long id);
}
