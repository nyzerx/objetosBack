package com.ObjetosUbb.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.ObjetosUbb.repository.TipoPublicacionRepository;

@Service
@Transactional
public class TipoPublicacionService {
    @Autowired
    private TipoPublicacionRepository tipoPublicacionRepository;

    public String getTipoPubli(long id){
        String optional = tipoPublicacionRepository.getCategoriaById(id);
        return optional;
    }
}
