package com.ObjetosUbb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ObjetosUbb.service.TipoPublicacionService;

@RestController
@RequestMapping(value = "/tipoPu",produces = "application/json")
public class TipoPuController {
    
    @Autowired
    private TipoPublicacionService tipoP;

    @GetMapping("/{id}")
    public ResponseEntity<String> getObjetoById(@PathVariable long id){
          String objeto = tipoP.getTipoPubli(id);
          if(!objeto.equals(null)){
               return new ResponseEntity<>(objeto,HttpStatus.OK);
          }else{
               return new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }
    }
}
