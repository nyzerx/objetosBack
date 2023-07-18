package com.ObjetosUbb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ObjetosUbb.repository.CategoriaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CategoriaService {
    
    @Autowired
    private CategoriaRepository categoriaRepository;

    public String getCategoria(long id){
        return categoriaRepository.getCategoriaById(id);
    }


}
