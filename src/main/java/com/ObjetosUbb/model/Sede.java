package com.ObjetosUbb.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sede")
public class Sede {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sede", nullable = false)
    private Long id_sede;

    @Column(name = "nombre_se", nullable = false)
    private String nombre_se;

    public Sede() {
    }

    public Sede(Long id_sede, String nombre_se) {
        this.id_sede = id_sede;
        this.nombre_se = nombre_se;
    }

    public Long getId_sede() {
        return id_sede;
    }

    public void setId_sede(Long id_sede) {
        this.id_sede = id_sede;
    }

    public String getNombre_se() {
        return nombre_se;
    }

    public void setNombre_se(String nombre_se) {
        this.nombre_se = nombre_se;
    }

    @Override
    public String toString() {
        return "Sede [id_sede=" + id_sede + ", nombre_se=" + nombre_se + "]";
    }

    
    
}
