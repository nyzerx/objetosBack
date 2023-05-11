package com.ObjetosUbb.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ObjetosUbb.model.Publicacion;

@Repository
public interface PublicacionRepository extends JpaRepository<Publicacion, Long>{   
}