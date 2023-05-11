package com.ObjetosUbb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ObjetosUbb.model.Objeto;
import com.ObjetosUbb.repository.ObjetoRepository;

@Service
@Transactional
public class ObjetoService {
    
    @Autowired
    private ObjetoRepository objetoRepository;

    public boolean crearObjeto(Objeto objeto) {
        Optional<Objeto> objetoOp = objetoRepository.findById(objeto.getId_obj());
        if(!objetoOp.isPresent()){
            objetoRepository.saveAndFlush(objeto);
            return true;
        }else{
            return false;
        }
    }

    public List<Objeto> obtenerObjetos() {
        return objetoRepository.findAll();
    }

    public Optional<Objeto> obtenerObjetoPorId(Long id) {
        return objetoRepository.findById(id);
    }

    public void actualizarObjeto(Objeto objeto) {
        objetoRepository.save(objeto);
    }


    public boolean eliminarObjeto(long id_objeto){
        try{
            objetoRepository.deleteById(id_objeto);
            return true;
        }catch(Exception err){
            return false;
        }
    }

}
