package com.ObjetosUbb.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "ubicacion")
@Data
public class Ubicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ub",nullable = false)
    private long id_ub;

    @Column(name = "nombre_ub", nullable = false)
    private String nombre;

    @Column(name = "hora_ub",nullable = false)
    private Date hora_ub;


    @ManyToOne(optional = true,fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name = "id_tipoub",nullable = false)
    private TipoUbicacion tipoUbicacion;

    @ManyToOne
    @JoinColumn(name = "id_sede", nullable = false)
    @JsonBackReference
    private Sede sede;

    @ManyToMany(cascade = CascadeType.ALL,mappedBy = "misUbicaciones")
    @JsonBackReference
    private List<Objeto> objetos;


}
