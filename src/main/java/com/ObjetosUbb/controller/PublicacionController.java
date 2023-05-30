package com.ObjetosUbb.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ObjetosUbb.model.Publicacion;
import com.ObjetosUbb.model.modelDTO.PubliDTO;
import com.ObjetosUbb.service.PublicacionService;
import com.ObjetosUbb.service.UsuarioService;
import com.ObjetosUbb.service.ComentarioService;
import com.ObjetosUbb.service.ObjetoService;
import com.ObjetosUbb.model.Publi;

@RestController
@RequestMapping(value = "/publicacion",produces = "application/json")
public class PublicacionController {

    @Autowired
    private PublicacionService publicacionService;
    
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ComentarioService comentarioService;
    
    @Autowired
    private ObjetoService objetoService;

    @PostMapping("/save")
    public ResponseEntity<Void> crearPublicacion(@RequestBody PubliDTO publicacion) {

       
       boolean creaPublicacion = publicacionService.crearPublicacion(publicacion);
       
       if(creaPublicacion){
            return new ResponseEntity<>(HttpStatus.CREATED);
       }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
       }
    }

    @GetMapping("/todos")
    public List <Publicacion>getPublicacionById(){
          return publicacionService.obtenerPublicacion();
    }

    @GetMapping("/nf")
    public List <Publi>getnfPublicacion(){
          return publicacionService.obtenerDatosPublicacion();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{idpub}")
    public ResponseEntity<Publicacion>getPublicacionById(@PathVariable long idpub){
          Optional<Publicacion> Publicaciones = publicacionService.obtenerPublicacionPorId(idpub);
          if(Publicaciones.isPresent()){
               return new ResponseEntity<>(Publicaciones.get(),HttpStatus.OK);
          }else{
               return new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }
    }

    @GetMapping("/filtro/{Nobjet}")
     public List<Publicacion>getpublicacionnom(@PathVariable String Nobjet){
          List<Publicacion> Publicaciones = publicacionService.obtenerPublicacionPorNombre(Nobjet);
          if(!Publicaciones.isEmpty()){
               return Publicaciones;
          }else{
               return null;
          }
    }

    @DeleteMapping("/Eliminar/{id_publicacion}/{id_usuario}")
    public String eliminarPorId(@PathVariable("id_publicacion")long id_publicacion,@PathVariable("id_usuario")long id_usuario){
          Optional<Publicacion> Publicaciones = publicacionService.obtenerPublicacionPorId(id_publicacion);
          if(Publicaciones.get().getUsuario().getId()==id_usuario||usuarioService.EsAdmin(id_usuario)){
               if(publicacionService.eliminarpublicacion(id_publicacion)&& comentarioService.eliminarComentarioPorpublicacion(id_publicacion)&&objetoService.eliminarObjeto(Publicaciones.get().getObjeto().getId_obj())){
                    return "Se elimino la publicacion con id "+ id_publicacion;
               }else{
                    return "Ocurrio un error al intentar eliminar la publicacion con id "+ id_publicacion;
               }
          }else{
               return "No tiene permisos para eliminar";
          }
    }
}