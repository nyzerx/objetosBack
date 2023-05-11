package com.ObjetosUbb.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "usuario")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_us",nullable = false)
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


    public Usuario() {
    }
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPswd() {
		return pswd;
	}
	public void setPswd(String pswd) {
		this.pswd = pswd;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public int getRol() {
		return rol;
	}
	public void setRol(int rol) {
		this.rol = rol;
	}

   

    @Override
    public String toString() {
        return "Usuario [id_us=" + id + ", nombre_us=" + nombre+ ", apellido_us=" + apellido+ ", pswd="
                + pswd + ", email=" + email + ", contacto=" + telefono + ", rol=" + rol + "]";
    }

    

    
}
