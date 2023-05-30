package com.ObjetosUbb.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ObjetosUbb.model.Publicacion;
import com.ObjetosUbb.model.modelDTO.PubliDTO;
import com.ObjetosUbb.model.Publi;
import com.ObjetosUbb.repository.ObjetoRepository;
import com.ObjetosUbb.repository.PublicacionRepository;



@Service
@Transactional
public class PublicacionService {

    private static Logger LOG = LoggerFactory.getLogger(PublicacionService.class);
    
    @Autowired
    private PublicacionRepository publicacionRepository;
    
    @Autowired 
    private ObjetoRepository objetoRepository;


    public boolean crearPublicacion(PubliDTO publicacion) {
        //Publicacion publiMapper = PublicacionMapper.mapDTOPublicacion(publicacion);
        try {
            //no debe existir el objeto que deseamos reportar antes
            LOG.info("el nombre del objeto es: "+publicacion.getObjeto().getNombre_obj());
            Optional<Long> optional  = objetoRepository.idObjetobyNombre(publicacion.getObjeto().getNombre_obj());

            if(!optional.isPresent()){ 
                objetoRepository.agregarObjeto(
                    publicacion.getObjeto().getNombre_obj(),
                    publicacion.getObjeto().getDescripcion_obj(),
                    publicacion.getObjeto().getImagen_obj(),
                    publicacion.getObjeto().getId_cat()
                );
                long idObj = objetoRepository.idObjetobyNombre(publicacion.getObjeto().getNombre_obj()).get().longValue();
                publicacionRepository.crearPublicacion(publicacion.getUsuario(),publicacion.getFechaHora(),publicacion.getTipoPublicacion(), publicacion.getEstado_pu(), idObj);
                return true;
            }
            LOG.info("ya existe un objeto con el id : "+optional.get());
            return false;
        } catch (Exception e) {
            LOG.error(e.getLocalizedMessage());
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
        try{
           return publicacionRepository.findById(id); 
        }catch(Exception ex){
            return null;
        }
        
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