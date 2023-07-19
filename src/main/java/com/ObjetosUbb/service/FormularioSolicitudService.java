package com.ObjetosUbb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ObjetosUbb.model.FormularioSolicitud;
import com.ObjetosUbb.repository.FormularioSolicitudRepository;

@Service
public class FormularioSolicitudService {

    private final FormularioSolicitudRepository formularioSolicitudRepository;

    @Autowired
    public FormularioSolicitudService(FormularioSolicitudRepository formularioSolicitudRepository) {
        this.formularioSolicitudRepository = formularioSolicitudRepository;
    }

    public FormularioSolicitud crearFormularioSolicitud(String nombre, String apellido, String correo, String motivo) {
        FormularioSolicitud formularioSolicitud = new FormularioSolicitud(nombre, apellido, correo, motivo);
        return formularioSolicitudRepository.save(formularioSolicitud);
    }
}
