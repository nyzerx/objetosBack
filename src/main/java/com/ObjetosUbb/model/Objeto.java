package com.ObjetosUbb.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name = "objeto")
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
      property = "id_obj")
public class Objeto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_obj")
    private Long id_obj;

    @Column(name = "nombre_obj")
    private String nombre_obj;

    @Column(name = "descripcion_obj")
    private String descripcion_obj;

    @Column(name = "imagen_obj",length = 300)
    private String imagen_obj;

    @ManyToOne(optional = true,fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name = "id_cat")
    private Categoria categoria;

 
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "objetoubicacion",joinColumns = @JoinColumn(name="id_obj")
    ,inverseJoinColumns = @JoinColumn(name="id_ub"))
    @JsonManagedReference
    @JsonIdentityReference(alwaysAsId = true)
    private List<Ubicacion> misUbicaciones;
  

    
}
