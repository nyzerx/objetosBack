package com.ObjetosUbb.repository;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ObjetosUbb.model.Publicacion;

@Repository
public interface PublicacionRepository extends JpaRepository<Publicacion, Long>{   
    @Modifying
    @Query(value="insert into publicacion (id_us,fecha_pu,id_tipopu,estado_pu,id_obj) values (:id_us,:fecha_pu,:id_tipopu,:estado_pu, :id_obj)",nativeQuery=true)
    void crearPublicacion(
        @Param("id_us") long id_us,
        @Param("fecha_pu") LocalDateTime fecha_pu,
        @Param("id_tipopu") long id_tipopu,
        @Param("estado_pu") int estado_pu,
        @Param("id_obj") long id_obj
    );

    Optional<Publicacion> findById(Long id);

    @Query(value = "SELECT * FROM publicacion WHERE id_us = :id",nativeQuery = true)
    List<Publicacion> getPostsbyIdUser(@Param("id") Long id);
}