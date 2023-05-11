package com.ObjetosUbb.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ObjetosUbb.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findUsuarioByEmail(String email);
	Optional<Usuario> findUsuarioByPswd(String psdw);
}
