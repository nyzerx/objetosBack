package com.ObjetosUbb.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tipoubicacion")
@Data
public class TipoUbicacion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipoub",nullable = false)
    private long id_tipoub;

    @Column(name = "nombre_tipoub", nullable = false)
    private String nombre;

}
