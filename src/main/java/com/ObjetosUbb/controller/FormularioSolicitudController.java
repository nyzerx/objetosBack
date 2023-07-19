package com.ObjetosUbb.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ObjetosUbb.model.FormularioSolicitud;
import com.ObjetosUbb.service.FormularioSolicitudService;

@RestController
@RequestMapping("/formulario-solicitud")
public class FormularioSolicitudController {

    private final FormularioSolicitudService formularioSolicitudService;

    public FormularioSolicitudController(FormularioSolicitudService formularioSolicitudService) {
        this.formularioSolicitudService = formularioSolicitudService;
    }

    @PostMapping("/guardar")
    public FormularioSolicitud guardarFormularioSolicitud(@RequestBody FormularioSolicitud formularioSolicitud) {
        return formularioSolicitudService.crearFormularioSolicitud(formularioSolicitud);
    }
}
