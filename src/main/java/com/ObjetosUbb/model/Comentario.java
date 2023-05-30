package com.ObjetosUbb.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "comentario")
@Data
public class Comentario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_co;

    @Column(name = "fecha_co")
    private Date fecha_co;

    @Column(name = "texto_co",nullable = false)
    private String texto_co;

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JsonBackReference()
    @JoinColumn(name = "id_us")
    private Usuario usuario;

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JsonBackReference()
    @JoinColumn(name = "id_pu", nullable = false)
    private Publicacion publicacion;

   
}
