package com.ObjetosUbb.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ObjetosUbb.repository.FormularioSolicitudRepository;
import com.ObjetosUbb.model.FormularioSolicitud;

@Service
public class FormularioSolicitudService {

    private final FormularioSolicitudRepository formularioSolicitudRepository;

    @Autowired
    public FormularioSolicitudService(FormularioSolicitudRepository formularioSolicitudRepository) {
        this.formularioSolicitudRepository = formularioSolicitudRepository;
    }

    public FormularioSolicitud crearFormularioSolicitud(String nombre, String apellido, String correo, String motivo, Long idPublicacion) {
        LocalDateTime fechaSolicitud = LocalDateTime.now();
        formularioSolicitudRepository.crearFormularioSolicitud(nombre, apellido, correo, motivo, idPublicacion, fechaSolicitud);
        return new FormularioSolicitud(nombre, apellido, correo, motivo, idPublicacion);
    }
}
