package com.ObjetosUbb.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ObjetosUbb.model.FormularioSolicitud;

public interface FormularioSolicitudRepository extends JpaRepository<FormularioSolicitud, Long> {

    @Modifying
    @Query(value = "INSERT INTO formulario_solicitud (nombre, apellido, correo, motivo, idPublicacion, fechaSolicitud) "
        + "VALUES (:nombre, :apellido, :correo, :motivo, :idPublicacion, :fechaSolicitud)", nativeQuery = true)
    void crearFormularioSolicitud(
        @Param("nombre") String nombre,
        @Param("apellido") String apellido,
        @Param("correo") String correo,
        @Param("motivo") String motivo,
        @Param("idPublicacion") Long idPublicacion,
        @Param("fechaSolicitud") LocalDateTime fechaSolicitud
    );
}
