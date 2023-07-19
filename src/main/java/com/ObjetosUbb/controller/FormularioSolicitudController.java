package com.ObjetosUbb.controller;

import org.springframework.web.bind.annotation.PutMapping;

import java.util.Optional;

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
    Optional<Publicacion> optionalPublicacion = publicacionService.obtenerPublicacionPorId(idPublicacion);
    if (optionalPublicacion.isPresent()) {
        Publicacion publicacion = optionalPublicacion.get();
        publicacion.setEstado_pu(nuevoEstado);
        return publicacionService.guardarPublicacion(publicacion);
    } else {
        // Manejar el caso de que no se encuentre la publicación con el idp especificado
        return null;
    }
}

}
