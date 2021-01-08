package com.prueba.ruleta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.ruleta.model.detalleApuesta;
import com.prueba.ruleta.service.detalleApuestaService;

@RestController
@RequestMapping(value="/detalle")
public class detalleApuestaController {
	
	@Autowired
	detalleApuestaService detalleServ;
	
	/**
	 * Method for to save the detail of an bet
	 * @param detalle
	 */
	@RequestMapping(method=RequestMethod.POST,path="/save")
	public void saveDetalle (@RequestBody detalleApuesta detalle){
		try{
			detalleServ.saveDetalle(detalle);
		}catch(Exception e){
			ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
}
