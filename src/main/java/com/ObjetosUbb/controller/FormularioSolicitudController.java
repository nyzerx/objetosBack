package com.ObjetosUbb.controller;

import com.ObjetosUbb.model.FormularioSolicitud;
import com.ObjetosUbb.service.FormularioSolicitudService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FormularioSolicitudController {

    private final FormularioSolicitudService formularioSolicitudService;

    @Autowired
    public FormularioSolicitudController(FormularioSolicitudService formularioSolicitudService) {
        this.formularioSolicitudService = formularioSolicitudService;
    }

    @PostMapping("/solicitud/{idPublicacion}")
    public ResponseEntity<FormularioSolicitud> crearFormularioSolicitud(@Valid @RequestBody FormularioSolicitud formularioSolicitud) {
        FormularioSolicitud newFormularioSolicitud = formularioSolicitudService.crearFormularioSolicitud(formularioSolicitud);
        return new ResponseEntity<>(newFormularioSolicitud, HttpStatus.CREATED);
    }
}
