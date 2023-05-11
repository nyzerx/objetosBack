package com.ObjetosUbb.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ObjetosUbb.model.Comentario;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
    
}
