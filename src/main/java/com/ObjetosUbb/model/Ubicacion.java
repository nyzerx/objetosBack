package com.ObjetosUbb.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ubicacion")
public class Ubicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ub",nullable = false)
    private long id_ub;

    @Column(name = "nombre_ub", nullable = false)
    private String nombre;

    @Column(name = "hora_ub",nullable = false)
    private Date hora_ub;


    @ManyToOne()
    @JoinColumn(name = "id_tipoub",nullable = false)
    private TipoUbicacion tipoUbicacion;

    @ManyToOne
    @JoinColumn(name = "id_sede", nullable = false)
    private Sede sede;

    @ManyToMany(mappedBy = "misUbicaciones")
    @JsonIgnoreProperties("misUbicaciones")
    private List<Objeto> objetos = new ArrayList<Objeto>();

    public Ubicacion() {
    }

    public Ubicacion(long id_ub, String nombre, Date hora_ub, TipoUbicacion tipoUbicacion, Sede sede) {
        this.id_ub = id_ub;
        this.nombre = nombre;
        this.hora_ub = hora_ub;
        this.tipoUbicacion = tipoUbicacion;
        this.sede = sede;
    }

    public long getId_ub() {
        return id_ub;
    }

    public void setId_ub(long id_ub) {
        this.id_ub = id_ub;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getHora_ub() {
        return hora_ub;
    }

    public void setHora_ub(Date hora_ub) {
        this.hora_ub = hora_ub;
    }

    public TipoUbicacion getTipoUbicacion() {
        return tipoUbicacion;
    }

    public void setTipoUbicacion(TipoUbicacion tipoUbicacion) {
        this.tipoUbicacion = tipoUbicacion;
    }

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }

    public List<Objeto> getObjetos() {
        return objetos;
    }

    public void setObjetos(List<Objeto> objetos) {
        this.objetos = objetos;
    }

    

}
