package com.ObjetosUbb.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Publi {
    private long idp;
    private String nombre;
    private String imagen;
    private long idu;
    private String Categoria;
    private LocalDateTime fechaHora;

    public Publi(long idp, String nombre, String imagen, long idu,LocalDateTime fechaHora, String  Categoria) {
        this.idp = idp;
        this.nombre = nombre;
        this.imagen = imagen;
        this.idu = idu;
        this.fechaHora = fechaHora;
        this.Categoria = Categoria;
    }
    public Publi(long idp, String nombre, String imagen, long idu,LocalDateTime fechaHora) {
        this.idp = idp;
        this.nombre = nombre;
        this.imagen = imagen;
        this.idu = idu;
        this.fechaHora = fechaHora;
    }


    public long getIdp() {
        return idp;
    }

    public void setIdp(long idp) {
        this.idp = idp;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public long getIdu() {
        return idu;
    }

    public void setIdu(long idu) {
        this.idu = idu;
    } 
    
    public LocalDateTime getFechaHora() {
        return fechaHora;
    }
    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getCategoria() {
        return this.Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }
}
