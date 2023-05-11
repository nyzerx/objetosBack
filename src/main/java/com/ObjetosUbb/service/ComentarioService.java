package com.ObjetosUbb.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ObjetosUbb.model.Comentario;
import com.ObjetosUbb.repository.ComentarioRepository;

@Service
@Transactional
public class ComentarioService {
    
    @Autowired
    private ComentarioRepository comentarioRepository;

    public List<Comentario> obtenerObjetos() {
        return comentarioRepository.findAll();
    }

    public Optional<Comentario> obtenerComentarioPorId(Long id) {
        return comentarioRepository.findById(id);
    }

    public Optional<List<Comentario>> obtenerComentarioPorIdPublicacion(Long id) {
        List<Comentario> c = comentarioRepository.findAll();
        List<Comentario> cc = new ArrayList<>();
        for (Comentario c1 : c) {
            if (c1.getPublicacion().getId_pu()==id) {
                cc.add(c1);
            }
        }
        return Optional.of(cc);
    }

    public boolean eliminarComentarioPorpublicacion(long id_publicacion){
        Optional<List<Comentario>> c = obtenerComentarioPorIdPublicacion(id_publicacion);
        if(c.isPresent()){
            if(c.get().isEmpty()){
                for (Comentario c1 : c.get()) {
                    if(!eliminarComentario(c1.getId_co())){
                        return false;
                    }
                }
                return true;
            }else{
                return true;
            }
        }else{
            return true;
        }
    }

    public boolean eliminarComentario(long id_comentario){
        try{
            comentarioRepository.deleteById(id_comentario);
            return true;
        }catch(Exception err){
            return false;
        }
    }
}