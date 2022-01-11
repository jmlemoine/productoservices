package com.example.productoservices.Services;

import com.example.productoservices.Entidades.Producto;

import java.util.List;

public interface IProductoService {
    public List<Producto> findAll();
    public Producto findById(long id);
}
