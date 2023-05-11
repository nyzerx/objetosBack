package com.ObjetosUbb.model;

import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name = "tipopublicacion")
public class TipoPublicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipopu",nullable = false)
    private long id_tipopu;

    @Column (name = "nombre_tipopu", nullable = false)
    private String nombre_tipopu;

    public TipoPublicacion() {
    }

    public TipoPublicacion(long id_tipopu, String nombre_tipopu) {
        this.id_tipopu = id_tipopu;
        this.nombre_tipopu = nombre_tipopu;
    }

    public long getId_tipopu() {
        return id_tipopu;
    }

    public void setId_tipopu(long id_tipopu) {
        this.id_tipopu = id_tipopu;
    }

    public String getNombre_tipopu() {
        return nombre_tipopu;
    }

    public void setNombre_tipopu(String nombre_tipopu) {
        this.nombre_tipopu = nombre_tipopu;
    }

    @Override
    public String toString() {
        return "TipoPublicacion [id_tipopu=" + id_tipopu + ", nombre_tipopu=" + nombre_tipopu + "]";
    }

    
}
