package com.ObjetosUbb.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ObjetosUbb.model.Usuario;
import com.ObjetosUbb.service.UsuarioService;

@RestController
@RequestMapping(value = "/usuario/", produces = "application/json")
public class UsuarioController {
	@Autowired
	private UsuarioService userService;
	
	@GetMapping(value = "/todos")
    public ResponseEntity<List<Usuario>> getAllUsers() {
        List<Usuario> userList = userService.findAllUsers();
        if (!userList.isEmpty()){
            return new ResponseEntity<>(userList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	@CrossOrigin(origins = "https://frontangular-production-938f.up.railway.app")
	@PostMapping(value = "")
    public ResponseEntity<Void> newUsuario(@RequestBody Usuario usuario) {
        boolean allright = userService.save(usuario);
        if (allright){
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @CrossOrigin(origins = "https://frontangular-production-938f.up.railway.app")
	@GetMapping(value = "/{email}/{pswd}")
    public ResponseEntity<Usuario> getUserByEmailAndPswd(@PathVariable String email,@PathVariable  String pswd) {
		Usuario user = null;
        Optional<Usuario> userOptional = userService.findUsuarioByEmail(email);
        if (userOptional.isPresent()) {
        	if(userService.findUsuarioByPswd(pswd).isPresent()) {
        		user = userService.findUsuarioById(userOptional.get().getId());
        		return new ResponseEntity<Usuario>( user,HttpStatus.OK);
        	}else {
        		return new ResponseEntity<Usuario>(user,HttpStatus.NOT_FOUND);
        	}
            
        } else {
            return new ResponseEntity<Usuario>(user,HttpStatus.NOT_FOUND);
        }
    }

}