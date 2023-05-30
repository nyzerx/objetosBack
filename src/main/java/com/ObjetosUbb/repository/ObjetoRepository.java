package com.ObjetosUbb.repository;


import org.hibernate.type.TrueFalseConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ObjetosUbb.model.Objeto;
import java.util.List;
import java.util.Optional;


@Repository
public interface ObjetoRepository extends JpaRepository<Objeto, Long>{
    @Modifying
    @Query(value = "Insert into objeto (nombre_obj,descripcion_obj,imagen_obj,id_cat) values (:nombre_obj, :descripcion_obj, :imagen_obj, :id_cat)", nativeQuery = true)
    void agregarObjeto(
        @Param("nombre_obj") String nombre_obj,
        @Param("descripcion_obj")String descripcion_obj, 
        @Param("imagen_obj") String imagen_obj,
        @Param("id_cat")long id_cat
    );

    @Query(value = "select id_obj from objeto where nombre_obj = :nombre",nativeQuery = true)
    Optional<Long> idObjetobyNombre(@Param("nombre")String nombre);

}