package com.ObjetosUbb.service;

import com.ObjetosUbb.model.FormularioSolicitud;
import com.ObjetosUbb.repository.FormularioSolicitudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormularioSolicitudService {

    private final FormularioSolicitudRepository formularioSolicitudRepository;

    @Autowired
    public FormularioSolicitudService(FormularioSolicitudRepository formularioSolicitudRepository) {
        this.formularioSolicitudRepository = formularioSolicitudRepository;
    }

    public FormularioSolicitud crearFormularioSolicitud(FormularioSolicitud formularioSolicitud) {
        return formularioSolicitudRepository.save(formularioSolicitud);
    }
}