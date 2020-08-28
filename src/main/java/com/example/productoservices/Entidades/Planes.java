package com.example.productoservices.Entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Planes implements Serializable {
    @Id
    private String nombre;
    private float costo;
    @OneToMany(mappedBy = "planes")
    private Set<Venta> ventas;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public Set<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(Set<Venta> ventas) {
        this.ventas = ventas;
    }
}
