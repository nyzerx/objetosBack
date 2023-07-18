package com.ObjetosUbb.model;

import java.time.LocalDateTime;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import com.ObjetosUbb.model.FormularioSolicitud;

@Entity
@Table(name = "publicacion")
@Data
public class Publicacion{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pu")
    private long id_pu;

    @ManyToOne(optional = true,fetch = FetchType.LAZY)
    @JsonBackReference()
    @JoinColumn(name = "id_us")
    private Usuario usuario;

    @Column(name = "fecha_pu")
    private LocalDateTime fechaHora;

    @ManyToOne(optional = true,fetch = FetchType.LAZY)
    @JsonBackReference()
    @JoinColumn(name = "id_tipopu")
    private TipoPublicacion tipoPublicacion;

    @Column(name = "estado_pu")
    private int estado_pu;

   
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonManagedReference()
    @JoinColumn(name = "id_obj")
    @JsonIdentityReference(alwaysAsId = true)
    private Objeto objeto;

    @OneToOne
    private FormularioSolicitud formularioSolicitud;
   
    @JsonManagedReference()
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "publicacion")
    private List<Comentario> comentarios;


}
