package com.ObjetosUbb.model;




import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;



@Entity
@Table(name = "categoría")
@Data
public class Categoria {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cat",nullable = false)
    private long id_cat;

    @Column(name = "nombre_cat",nullable = false)
    private String nombre_cat;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="categoria")
    @JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id_obj" )
    @JsonManagedReference
    @JsonIdentityReference(alwaysAsId = true)
    private List<Objeto> objetos;

   
    
    

    
}
