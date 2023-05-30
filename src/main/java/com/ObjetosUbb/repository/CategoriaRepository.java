package com.ObjetosUbb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ObjetosUbb.model.Categoria;


@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    @Query(value = "SELECT nombre_cat FROM categoría WHERE id_cat = :id", nativeQuery = true)
    String getCategoriaById(@Param("id")long id);
}