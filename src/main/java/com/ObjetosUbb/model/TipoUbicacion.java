package com.ObjetosUbb.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tipoubicacion")
public class TipoUbicacion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipoub",nullable = false)
    private long id_tipoub;

    @Column(name = "nombre_tipoub", nullable = false)
    private String nombre;

    public TipoUbicacion() {
    }

    public TipoUbicacion(long id_tipoub, String nombre) {
        this.id_tipoub = id_tipoub;
        this.nombre = nombre;
    }

    public long getId_tipoub() {
        return id_tipoub;
    }

    public void setId_tipoub(long id_tipoub) {
        this.id_tipoub = id_tipoub;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "TipoUbicacion [id_tipoub=" + id_tipoub + ", nombre=" + nombre + "]";
    }

    
}
