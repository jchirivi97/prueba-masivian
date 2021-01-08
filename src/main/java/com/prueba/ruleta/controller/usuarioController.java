package com.prueba.ruleta.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.ruleta.service.usuarioService;
import com.prueba.ruleta.model.usuario;

@RestController
@RequestMapping(value="/user")
public class usuarioController {
	
	@Autowired
	usuarioService usuarioServ;
	
	/**
	 * Method Controller for login of the a user
	 * @param id
	 * @param password
	 * @return boolean 
	 */
	@RequestMapping(method=RequestMethod.GET,path="/login/{id}/{pass}")
	public boolean loginUser(@PathVariable(name="id")int id,@PathVariable(name="pass") String password){
		try{
			usuarioServ.login(id, password);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	/**
	 * Method Controller for to save a user
	 * @param user
	 * @return
	 */
	@RequestMapping(method=RequestMethod.POST,path="/save")
	public ResponseEntity<?> saveUser(@RequestBody usuario user){
		try{
			usuarioServ.saveUser(user);
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		}catch(Exception e){
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	/**
	 * Method Controller for to update the credits of the user
	 * @param id
	 * @param credito
	 * @return
	 */
	@RequestMapping(method=RequestMethod.PUT,path="/credito/{id}/{credito}")
	public ResponseEntity<?> updateCredito(@PathVariable(name="id") int id,@PathVariable(name="credito") int credito){
		try{
			usuarioServ.updateCredito(id, credito);
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		}catch(Exception e){
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	/**
	 * Method Controller for to get a user
	 * @param id
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET,path="/getUser/{id}")
	public ResponseEntity<usuario> getUser(@PathVariable(name="id") int id){
		try{
			return ResponseEntity.ok(usuarioServ.getUser(id));
		}catch(Exception e){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}	
}
