package com.example.itemservice.controllers.DAO;

import com.example.itemservice.models.Planes;

public class PlanesDao {
    public String nombre;
    public float costo;

    public PlanesDao(){

    }
    public PlanesDao(String nombre, float costo) {
        this.nombre = nombre;
        this.costo = costo;
    }

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
}
