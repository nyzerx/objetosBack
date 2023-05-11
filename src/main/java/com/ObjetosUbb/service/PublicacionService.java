package com.ObjetosUbb.service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ObjetosUbb.model.Publicacion;
import com.ObjetosUbb.model.Publi;
import com.ObjetosUbb.repository.PublicacionRepository;

@Service
@Transactional
public class PublicacionService {
    
    @Autowired
    private PublicacionRepository publicacionRepository;

    public boolean crearPublicacion(Publicacion publicacion) {
        Optional<Publicacion>  publicacionc= publicacionRepository.findById(publicacion.getId_pu());
        if(!publicacionc.isPresent()){
            publicacionRepository.saveAndFlush(publicacion);
            return true;
        }else{
            return false;
        }
    }

    public List<Publicacion> obtenerPublicacion() {
        return publicacionRepository.findAll();
    }

    public List<Publi> obtenerDatosPublicacion() {
        List<Publi> publ = new ArrayList<>(); 
        for (Publicacion publicacion : publicacionRepository.findAll()) {
           Publi p = new Publi(publicacion.getId_pu(), publicacion.getObjeto().getNombre_obj(),publicacion.getObjeto().getImagen_obj(),
           publicacion.getUsuario().getId(),publicacion.getFechaHora());
           publ.add(p);
        }
        return publ;
    }

    public List<Publicacion> obtenerPublicacionPorNombre(String nombre) {
        List<Publicacion> publicacionn = new ArrayList<>();
        for (Publicacion publicacion : publicacionRepository.findAll()) {
            if (publicacion.getObjeto().getNombre_obj().equals(nombre)) {
                publicacionn.add(publicacion);
            }
        }
        return publicacionn;
    }

    public Optional<Publicacion> obtenerPublicacionPorId(Long id) {
        return publicacionRepository.findById(id);
    }

    public void actualizarPublicacion(Publicacion publicacion) {
        publicacionRepository.save(publicacion);
    }

    public boolean eliminarpublicacion(long id_publicacion){
        try{
            publicacionRepository.deleteById(id_publicacion);
            return true;
        }catch(Exception err){
            return false;
        }
    }
}