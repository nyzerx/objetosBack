package com.ObjetosUbb.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "comentario")
public class Comentario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_co;

    @Column(name = "fecha_co")
    private Date fecha_co;

    @Column(name = "texto_co",nullable = false)
    private String texto_co;

    @ManyToOne()
    @JoinColumn(name = "id_us")
    private Usuario usuario;

    @ManyToOne()
    @JoinColumn(name = "id_pu", nullable = false)
    private Publicacion publicacion;

    public Comentario() {
    }

    public long getId_co() {
        return id_co;
    }

    public void setId_co(long id_co) {
        this.id_co = id_co;
    }

    public Date getFecha_co() {
        return fecha_co;
    }

    public void setFecha_co(Date fecha_co) {
        this.fecha_co = fecha_co;
    }

    public String getTexto_co() {
        return texto_co;
    }

    public void setTexto_co(String texto_co) {
        this.texto_co = texto_co;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Publicacion getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(Publicacion publicacion) {
        this.publicacion = publicacion;
    }
   
}
