package com.example.productoservices.Dao;

import com.example.productoservices.Entidades.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductoDao extends CrudRepository <Producto, Long>{
}
