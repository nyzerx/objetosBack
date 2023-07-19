package com.ObjetosUbb.model;

import com.ObjetosUbb.model.Publicacion;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

import javax.persistence.Column;

@Entity
@Table(name = "formulario_solicitud")
public class FormularioSolicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;
    private String correo;
    private String motivo;
    private LocalDateTime fechaSolicitud;

    @Column(name = "id_pub")
    private Long idPublicacion;

    @OneToOne(mappedBy = "formularioSolicitud")
    private Publicacion publicacion;

    public FormularioSolicitud() {
    }

    public FormularioSolicitud(String nombre, String apellido, String correo, String motivo, Long idPublicacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.motivo = motivo;
        this.idPublicacion = idPublicacion;
        this.fechaSolicitud = LocalDateTime.now();
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDateTime getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(LocalDateTime fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Long getIdPublicacion() {
        return idPublicacion;
    }

    public void setIdPublicacion(Long idPublicacion) {
        this.idPublicacion = idPublicacion;
    }
    
}
