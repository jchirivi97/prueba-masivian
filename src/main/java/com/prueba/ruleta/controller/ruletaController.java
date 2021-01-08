package com.prueba.ruleta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.ruleta.model.ruleta;
import com.prueba.ruleta.service.ruletaService;

@RestController
@RequestMapping(value="/rulette")
public class ruletaController {
	
	@Autowired
	ruletaService ruletaServ;
	
	/**
	 * Method for to active a roulette  
	 * @param roulette
	 * @return boolean
	 */
	@RequestMapping(method=RequestMethod.POST,path="/open")
	public boolean openRullete(@RequestBody ruleta roulette){
		try{
			return ruletaServ.openRuleta(roulette);
		}catch(Exception e){
			return false;
		}
	}
	
	/**
	 * Method for to get a roulette
	 * @param id
	 * @return ruleta
	 */
	@RequestMapping(method=RequestMethod.GET,path="/get/{id}")
	public ResponseEntity<ruleta> getRoulette(@PathVariable(name="id") int id){
		try{
			return ResponseEntity.ok(ruletaServ.getRuleta(id));
		}catch(Exception e){
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	/**
	 * method for to get all roulettes
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET,path="/all")
	public ResponseEntity<List<ruleta>> getAllRoulettes(){
		try{
			return ResponseEntity.ok(ruletaServ.allRuletas());
		}catch(Exception e){
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
}
