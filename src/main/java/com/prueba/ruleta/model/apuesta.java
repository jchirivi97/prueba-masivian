package com.prueba.ruleta.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="apuesta")
public class apuesta {

	@Id
	@GeneratedValue( strategy=GenerationType.AUTO )
	private int id;
	private Date fecha;
	private int valortotal;
	private int usuario;
	private int ruleta;
	
	public apuesta(){
		
	}
	
	public apuesta(int id, Date fecha, int valortotal, int usuario, int ruleta) {
		this.id = id;
		this.fecha = fecha;
		this.valortotal = valortotal;
		this.usuario = usuario;
		this.ruleta = ruleta;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getValortotal() {
		return valortotal;
	}

	public void setValortotal(int valortotal) {
		this.valortotal = valortotal;
	}

	public int getUsuario() {
		return usuario;
	}

	public void setUsuario(int usuario) {
		this.usuario = usuario;
	}

	public int getRuleta() {
		return ruleta;
	}

	public void setRuleta(int ruleta) {
		this.ruleta = ruleta;
	}
}
