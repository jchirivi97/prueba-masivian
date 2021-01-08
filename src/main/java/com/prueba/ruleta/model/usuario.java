package com.prueba.ruleta.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class usuario {
	@Id
	private int documento;
	private String nombre;
	private String apellido;
	private String password;
	private int credito;
	private int rol;
	
	public usuario(){
		
	}
	
	public usuario(int documento, String nombre, String apellido,
			String password) {
		this.documento = documento;
		this.nombre = nombre;
		this.apellido = apellido;
		this.password = password;
	}

	public int getDocumento() {
		return documento;
	}

	public void setDocumento(int documento) {
		this.documento = documento;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getCredito() {
		return credito;
	}

	public void setCredito(int credito) {
		this.credito = credito;
	}
	
	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}
}
