package com.example.productoservices.Repositorio;

import com.example.productoservices.Entidades.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentaRepositorio extends JpaRepository<Venta, Long> {
}
