package com.ObjetosUbb.model.modelDTO;

import java.io.Serializable;
import java.util.List;

public class ObjetoDTO implements Serializable{
    
    private String nombre_obj;
    private String descripcion_obj;
    private String imagen_obj;
    private long id_cat;
    private List<Long>misUbicaciones;
    
    public ObjetoDTO(String nombre_obj, String descripcion_obj, String imagen_obj, long id_cat,
            List<Long> misUbicaciones) {
        this.nombre_obj = nombre_obj;
        this.descripcion_obj = descripcion_obj;
        this.imagen_obj = imagen_obj;
        this.id_cat = id_cat;
        this.misUbicaciones = misUbicaciones;
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

    public long getId_cat() {
        return id_cat;
    }

    public void setId_cat(long id_cat) {
        this.id_cat = id_cat;
    }

    public List<Long> getMisUbicaciones() {
        return misUbicaciones;
    }

    public void setMisUbicaciones(List<Long> misUbicaciones) {
        this.misUbicaciones = misUbicaciones;
    }

    

    
}
