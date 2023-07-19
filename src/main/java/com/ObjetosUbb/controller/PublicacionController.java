package com.ObjetosUbb.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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

    @GetMapping("/ultimas")
    public List <Publi> ultimPublicacions(){
          return publicacionService.ultimasPublicaciones();
    }

    @GetMapping("/datos/{idp}")
     public Publi obtenerPublicacionPorId(@PathVariable Long idp){
     return publicacionService.obtenerPublicacionPorId2(idp);
     }

    @GetMapping("/todos")
    public List <Publicacion>getPublicacionById(){
          return publicacionService.obtenerPublicacion();
    }

    @GetMapping("/nf")
    public List <Publi>getnfPublicacion(){
          return publicacionService.obtenerDatosPublicacion();
    }

    @CrossOrigin(origins = "https://frontangular-production-938f.up.railway.app")
    @GetMapping("/nf/{idpub}")
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

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file){
         
          String uploadsDir = "src/main/resources/uploads";
          String filename = UUID.randomUUID().toString() + "-" + file.getOriginalFilename();
          File fileimage = new File(uploadsDir,filename);

          try {
               file.transferTo(fileimage);
          
               return ResponseEntity.ok("Imagen subida exitosamente");
              
          } catch (IOException e) {
              return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al subir la imagen");
          }
          
    }

    @GetMapping("/reportes/{idUser}")
    public ResponseEntity<List<Publicacion>> getPostsByIdUser(@PathVariable Long idUser) {
        List<Publicacion> publicacions = publicacionService.getPostByIdUser(idUser);
        if(!publicacions.isEmpty()){
          return new ResponseEntity<>(publicacions,HttpStatus.OK);
        }else{
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/actualizar/{id_pu}")
    public ResponseEntity<?> actualizarEstadoPublicacion(@PathVariable Long id_pu) {
        try {
            // Actualiza el estado de la publicación usando el servicio PublicacionService
            publicacionService.actualizarEstadoPublicacion(id_pu);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al actualizar el estado de la publicación");
        }
    }
    
}