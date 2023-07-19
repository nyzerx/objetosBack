package com.ObjetosUbb.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Publi {
    private long idp;
    private String nombre;
    private String imagen;
    private String descripcion;
    private long idu;
    private String Categoria;
    private LocalDateTime fechaHora;
    private String nombreUsuario;
    private String apellidoUsuario;
    private int estado_pu;

    public Publi(long idp, String nombre, String imagen, long idu,LocalDateTime fechaHora, String  Categoria) {
        this.idp = idp;
        this.nombre = nombre;
        this.imagen = imagen;
        this.idu = idu;
        this.fechaHora = fechaHora;
        this.Categoria = Categoria;
    }

    public Publi(long idp, String nombre, String imagen, String descripcion, long idu,LocalDateTime fechaHora, String  Categoria, String nombreUsuario, int estado_pu) {
        this.idp = idp;
        this.nombre = nombre;
        this.imagen = imagen;
        this.descripcion = descripcion;
        this.idu = idu;
        this.fechaHora = fechaHora;
        this.Categoria = Categoria;
        this.nombreUsuario = nombreUsuario;
        this.estado_pu = estado_pu;
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

    public String getFechaHoraString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return this.fechaHora.format(formatter);
    }

    public String getNombreUsuario() {
        return this.nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoUsuario() {
        return this.apellidoUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getEstado_pu() {
        return this.estado_pu;
    }

    public void setEstado_pu(int estado_pu) {
        this.estado_pu = estado_pu;
    }
}
