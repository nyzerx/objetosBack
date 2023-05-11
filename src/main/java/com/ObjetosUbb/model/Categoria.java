package com.ObjetosUbb.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "categoría")
public class Categoria {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cat",nullable = false)
    private long id_cat;

    @Column(name = "nombre_cat",nullable = false)
    private String nombre_cat;

    

    public Categoria(long id_cat, String nombre_cat) {
        this.id_cat = id_cat;
        this.nombre_cat = nombre_cat;
    }

    public Categoria() {
    }

    public long getId_cat() {
        return id_cat;
    }

    public void setId_cat(long id_cat) {
        this.id_cat = id_cat;
    }

    public String getNombre_cat() {
        return nombre_cat;
    }

    public void setNombre_cat(String nombre_cat) {
        this.nombre_cat = nombre_cat;
    }

    @Override
    public String toString() {
        return "Categoria [id_cat=" + id_cat + ", nombre_cat=" + nombre_cat + "]";
    }

    

    
}
