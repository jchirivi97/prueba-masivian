package com.prueba.ruleta.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="detalle_apuesta")
public class detalleApuesta {
	
	@Id
	@GeneratedValue( strategy=GenerationType.AUTO )
	private int id;
	private String descripcion;
	private int apuesta;
	private int valor;
	
	public detalleApuesta(){
		
	}
	
	public detalleApuesta(int id, String descripcion, int apuesta) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.apuesta = apuesta;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public int getApuesta() {
		return apuesta;
	}
	
	public void setApuesta(int apuesta) {
		this.apuesta = apuesta;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
}
