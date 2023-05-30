package com.ObjetosUbb.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "usuario")
@Data
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_us")
    private int id;

	@Column(name = "nombre_us")
	private String nombre;

	@Column(name = "apellido_us")
	private String apellido;

	@Column(name = "email_us")
	private String email;

	@Column(name = "contraseña")
	private String pswd;

	@Column(name = "contacto")
	private int telefono;
	
    @Column(name = "rol")
	private int rol;
}
