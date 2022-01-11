package com.example.productoservices.Services;

import com.example.productoservices.Controladores.DAO.LoginResponse;
import com.example.productoservices.Controladores.DAO.VentaDao;
import com.example.productoservices.Entidades.Planes;
import com.example.productoservices.Entidades.Producto;
import com.example.productoservices.Entidades.Venta;
import com.example.productoservices.Repositorio.PlanRepositorio;
import com.example.productoservices.Repositorio.VentaRepositorio;
import com.sendgrid.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Service
public class ServicioProducto {
    @Autowired
    PlanRepositorio planRepositorio;
    @Autowired
    VentaRepositorio ventaRepositorio;
    @Autowired
    RestTemplate restTemplate;

    public void crearPlanes (){
        Planes plan1 = new Planes();
        Planes plan2 = new Planes();
        Planes plan3 = new Planes();
        Planes plan4 = new Planes();

        plan1.setCosto(1000);
        plan1.setNombre("Pre-Boda");
        plan2.setCosto(5000);
        plan2.setNombre("Boda");
        plan3.setCosto(3000);
        plan3.setNombre("Cumpleaños");
        plan4.setCosto(4000);
        plan4.setNombre("Video de evento");

        planRepositorio.save(plan1);
        planRepositorio.save(plan2);
        planRepositorio.save(plan3);
        planRepositorio.save(plan4);
    }

    public Venta crearVenta (Planes planes, String codigoUsuario){
        Venta venta = new Venta();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        Date date = new Date();

        venta.setUsuario(codigoUsuario);
        venta.setMonto(planes.getCosto());
        venta.setPlanes(planes);
        venta.setFecha_venta(date);
        ventaRepositorio.save(venta);
        return venta;
    }
}
