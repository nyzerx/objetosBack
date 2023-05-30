package com.ObjetosUbb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ObjetosUbb.model.Comentario;
import com.ObjetosUbb.model.TipoPublicacion;

@Repository
public interface TipoPublicacionRepository extends JpaRepository<TipoPublicacion, Long> {
    @Query(value = "SELECT nombre_tipopu FROM tipopublicacion WHERE id_tipopu = :id", nativeQuery = true)
    String getCategoriaById(@Param("id")long id);
}
