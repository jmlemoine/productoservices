package com.example.itemservice.controllers;

import com.example.itemservice.controllers.DAO.PlanesDao;
import com.example.itemservice.controllers.DAO.VentaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/planes/")
public class PlanesController {
    @Autowired
    RestTemplate restTemplate;

    @PostMapping()
    public VentaDao agregarVenta (@RequestBody VentaDao ventaDAO){
        VentaDao v = restTemplate.postForObject("http://servicio-productos/api/venta",ventaDAO, VentaDao.class);
        return v;
    }

    @GetMapping
    public PlanesDao[] getPlanes(){
        return restTemplate.getForObject("http://servicio-productos/api/venta",PlanesDao[].class);

    }
}
