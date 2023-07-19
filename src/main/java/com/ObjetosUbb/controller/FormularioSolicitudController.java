package com.ObjetosUbb.controller;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.ObjetosUbb.model.Publicacion;
import com.ObjetosUbb.service.PublicacionService;

@RestController
public class FormularioSolicitudController {

    private final PublicacionService publicacionService;

    public FormularioSolicitudController(PublicacionService publicacionService) {
        this.publicacionService = publicacionService;
    }

    @PutMapping("/publicacion/{idPublicacion}/estado/{nuevoEstado}")
    public Publicacion actualizarEstadoPublicacion(@PathVariable Long idPublicacion, @PathVariable Integer nuevoEstado) {
        Publicacion publicacion = publicacionService.obtenerPublicacionPorId(idPublicacion);
        if (publicacion != null) {
            publicacion.setEstado_pu(nuevoEstado);
            return publicacionService.guardarPublicacion(publicacion);
        } else {
            throw new ResourceNotFoundException("Publicación no encontrada con ID: " + idPublicacion);
        }
    }
}
