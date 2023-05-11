package com.ObjetosUbb.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "objeto")
public class Objeto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_obj",nullable = false)
    private Long id_obj;

    @Column(name = "nombre_obj", nullable = false)
    private String nombre_obj;

    @Column(name = "descripcion_obj", nullable = false)
    private String descripcion_obj;

    @Column(name = "imagen_obj",length = 300)
    private String imagen_obj;

    @ManyToOne 
    @JoinColumn(name = "id_cat", nullable = false)
    private Categoria categoria;

    
    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(name = "objetoubicacion",joinColumns = @JoinColumn(name="id_obj")
    ,inverseJoinColumns = @JoinColumn(name="id_ub"))
    @JsonIgnoreProperties("objetos")
    private List<Ubicacion> misUbicaciones =new ArrayList<Ubicacion>();
  

    public Objeto() {
    }


    public Objeto(Long id_obj, String nombre_obj, String descripcion_obj, String imagen_obj, Categoria categoria,
            List<Ubicacion> misUbicaciones) {
        this.id_obj = id_obj;
        this.nombre_obj = nombre_obj;
        this.descripcion_obj = descripcion_obj;
        this.imagen_obj = imagen_obj;
        this.categoria = categoria;
        this.misUbicaciones = misUbicaciones;
    }


    public Long getId_obj() {
        return id_obj;
    }


    public void setId_obj(Long id_obj) {
        this.id_obj = id_obj;
    }


    public String getNombre_obj() {
        return nombre_obj;
    }


    public void setNombre_obj(String nombre_obj) {
        this.nombre_obj = nombre_obj;
    }


    public String getDescripcion_obj() {
        return descripcion_obj;
    }


    public void setDescripcion_obj(String descripcion_obj) {
        this.descripcion_obj = descripcion_obj;
    }


    public String getImagen_obj() {
        return imagen_obj;
    }


    public void setImagen_obj(String imagen_obj) {
        this.imagen_obj = imagen_obj;
    }


    public Categoria getCategoria() {
        return categoria;
    }


    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }


    public List<Ubicacion> getMisUbicaciones() {
        return misUbicaciones;
    }


    public void setMisUbicaciones(List<Ubicacion> misUbicaciones) {
        this.misUbicaciones = misUbicaciones;
    }

    public void addUbicacion(Ubicacion ubi){
        misUbicaciones.add(ubi);
        ubi.getObjetos().add(this);
    }

    public void eliminarUbicacion(Ubicacion ubi){
        misUbicaciones.remove(ubi);
        ubi.getObjetos().remove(this);
    }

}
