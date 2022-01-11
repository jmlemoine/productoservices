package com.example.usuarioservice.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Rol implements Serializable {

    @Id
    private String role;
    /* @GeneratedValue
        private long id;*/
    public Rol(){

    }

/*    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }*/

    public Rol(String role){
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
