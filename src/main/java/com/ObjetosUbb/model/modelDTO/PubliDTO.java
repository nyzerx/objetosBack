package com.ObjetosUbb.model.modelDTO;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;


public class PubliDTO implements Serializable{

    
    private long usuario;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",shape = JsonFormat.Shape.STRING)
    private LocalDateTime fechaHora;
    private long tipoPublicacion;
    private int estado_pu;
    private ObjetoDTO objeto;
    private List<Long> comentarios;

    public PubliDTO() {
    }

    public PubliDTO(long usuario, LocalDateTime fechaHora, long tipoPublicacion, int estado_pù, ObjetoDTO objeto,
            List<Long> comentarios) {
        this.usuario = usuario;
        this.fechaHora = fechaHora;
        this.tipoPublicacion = tipoPublicacion;
        this.estado_pu = estado_pù;
        this.objeto = objeto;
        this.comentarios = comentarios;
    }



    public long getUsuario() {
        return usuario;
    }

    public void setUsuario(long usuario) {
        this.usuario = usuario;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public long getTipoPublicacion() {
        return tipoPublicacion;
    }

    public void setTipoPublicacion(long tipoPublicacion) {
        this.tipoPublicacion = tipoPublicacion;
    }

    public int getEstado_pu() {
        return estado_pu;
    }

    public void setEstado_pu(int estado_pù) {
        this.estado_pu = estado_pù;
    }

    public ObjetoDTO getObjeto() {
        return objeto;
    }

    public void setObjeto(ObjetoDTO objeto) {
        this.objeto = objeto;
    }

    public List<Long> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Long> comentarios) {
        this.comentarios = comentarios;
    }
   
    
    

    
    

}