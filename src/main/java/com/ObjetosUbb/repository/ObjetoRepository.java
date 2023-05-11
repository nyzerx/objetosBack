package com.ObjetosUbb.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ObjetosUbb.model.Objeto;

@Repository
public interface ObjetoRepository extends JpaRepository<Objeto, Long>{
}