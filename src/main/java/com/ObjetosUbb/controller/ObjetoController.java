package com.ObjetosUbb.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ObjetosUbb.model.Objeto;
import com.ObjetosUbb.service.ObjetoService;

@RestController
@RequestMapping(value = "/objetos",produces = "application/json")
public class ObjetoController {
    
    @Autowired
    private ObjetoService objetoService;

    @PostMapping("")
    public ResponseEntity<Void> crearObjeto(@RequestBody Objeto objeto) {
       boolean crearObjeto = objetoService.crearObjeto(objeto);
       if(crearObjeto){
            return new ResponseEntity<>(HttpStatus.CREATED);
       }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
       }
    }

    @GetMapping("/{idObj}")
    public ResponseEntity<Objeto>getObjetoById(@PathVariable long idObj){
          Optional<Objeto> objeto = objetoService.obtenerObjetoPorId(idObj);
          if(objeto.isPresent()){
               return new ResponseEntity<>(objeto.get(),HttpStatus.OK);
          }else{
               return new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }
    }


}
