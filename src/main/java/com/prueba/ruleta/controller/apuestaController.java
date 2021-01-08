package com.prueba.ruleta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.ruleta.model.apuesta;
import com.prueba.ruleta.service.apuestaService;

@RestController
@RequestMapping(value="/bet")
public class apuestaController {
	
	@Autowired
	apuestaService apuestaServ;
	
	/**
	 * Method to access the service of save bets
	 * @param bet
	 */	
	@RequestMapping(method=RequestMethod.POST,path="/save")
	public ResponseEntity<List<apuesta>> saveApuesta (@RequestBody apuesta bet){
		try{
			return ResponseEntity.ok(apuestaServ.saveApuesta(bet));
		}catch(Exception e){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
