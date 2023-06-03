package com.ObjetosUbb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ObjetosUbb.model.Usuario;
import com.ObjetosUbb.repository.UsuarioRepository;

@Service
@Transactional
public class UsuarioService {
     
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> obtenerUsuario() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> obtenerUsuarioPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public Boolean EsAdmin(long id) {
        Optional<Usuario> s = usuarioRepository.findById(id);
        if (s.isPresent()) {
            if(s.get().getRol()==2){ 
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    public UsuarioService (UsuarioRepository userRep) {
        this.usuarioRepository = userRep;
    }
    public List<Usuario> findAllUsers() {
        return usuarioRepository.findAll();
    }
    public Usuario findUsuarioById(long id) {
    	return usuarioRepository.getById(id);
    }

    public boolean save(Usuario user) {
        usuarioRepository.saveAndFlush(user);
        Optional<Usuario> userOptional = usuarioRepository.findUsuarioByEmail(user.getEmail());
        return userOptional.isPresent();
    }
    
    public Optional<Usuario> findUsuarioByEmail(String email) {
        return usuarioRepository.findUsuarioByEmail(email);
    }
    public Optional<Usuario> findUsuarioByPswd(String pswd) {
        return usuarioRepository.findUsuarioByPswd(pswd);
    }

}

