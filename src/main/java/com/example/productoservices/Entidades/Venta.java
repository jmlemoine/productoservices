package com.example.productoservices.Entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Venta implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long codigo;
    private float monto;
    private String usuario;
    private Date fecha_venta;
    @ManyToOne(fetch = FetchType.LAZY)
    private Planes planes;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Date getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(Date fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public Planes getPlanes() {
        return planes;
    }

    public void setPlanes(Planes planes) {
        this.planes = planes;
    }
}
