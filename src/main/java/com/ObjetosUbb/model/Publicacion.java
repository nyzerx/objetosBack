package com.ObjetosUbb.model;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "publicacion")
public class Publicacion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pu", nullable = false)
    private Long id_pu;

    @ManyToOne
    @JoinColumn(name = "id_us", nullable = false)
    private Usuario usuario;

    @Column(name = "fecha_pu", nullable = false)
    private LocalDateTime fechaHora;

    @ManyToOne
    @JoinColumn(name = "id_tipopu", nullable = false)
    private TipoPublicacion tipoPublicacion;

    @Column(name = "estado_pu", nullable = false)
    private int estado_pu;

   
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_obj")
    private Objeto objeto;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "publicacion")
    private List<Comentario> comentarios;

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public Publicacion() {
    }

    

    
    public Long getId_pu() {
        return id_pu;
    }




    public void setId_pu(Long id_pu) {
        this.id_pu = id_pu;
    }




    public Usuario getUsuario() {
        return usuario;
    }




    public LocalDateTime getFechaHora() {
        return fechaHora;
    }




    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }




    public TipoPublicacion getTipoPublicacion() {
        return tipoPublicacion;
    }




    public void setTipoPublicacion(TipoPublicacion tipoPublicacion) {
        this.tipoPublicacion = tipoPublicacion;
    }




    public int getEstado_pu() {
        return estado_pu;
    }




    public void setEstado_pu(int estado_pu) {
        this.estado_pu = estado_pu;
    }




    public Objeto getObjeto() {
        return objeto;
    }




    public void setObjeto(Objeto objeto) {
        this.objeto = objeto;
    }




    public List<Comentario> getComentarios() {
        return comentarios;
    }




    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }




    public static DateTimeFormatter getFormatter() {
        return formatter;
    }




    

    public void setFechaHora(String fechaHora) {
        this.fechaHora = LocalDateTime.parse(fechaHora, formatter);
    }

   
}
