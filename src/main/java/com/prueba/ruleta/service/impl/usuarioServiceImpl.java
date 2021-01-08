package com.prueba.ruleta.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.ruleta.model.usuario;
import com.prueba.ruleta.repository.usuarioRepository;
import com.prueba.ruleta.service.usuarioService;

@Service
public class usuarioServiceImpl implements usuarioService {
	
	@Autowired
	private usuarioRepository usuarioRep;

	/**
	 * Method for get a user
	 * @param id The parameter is the document of the user
	 * @return user
	 */
	@Override
	public usuario getUser(int id) throws Exception {
		try{
			return usuarioRep.findById(id).get();
		}catch(Exception e){
			throw new Exception("Usuario no existe");
		}
	}

	/**
	 * Method for to login a user
	 * @param id The parameter is the document of the user and password of the user
	 * @return user  
	 */
	@Override
	public usuario login(int id, String password) throws Exception {
		try{
			System.out.println("login: "+ id + " " + password);
			return usuarioRep.loginUser(id, password);
		}catch(Exception e){
			throw new Exception("Usuario no existe");
		}
	}

	/**
	 * Method for to save a user
	 *@param user
	 */
	@Override
	public void saveUser(usuario user) throws Exception {
		try{
			usuarioRep.save(user);
		}catch(Exception e){
			throw new Exception("No es posible guardar el usuario");
		}	
	}

	@Override
	public void updateCredito(int id, int credito) throws Exception {
		try{
			usuarioRep.updateCredito(id, credito);;
		}catch(Exception e){
			throw new Exception("No es posible actualizar el usuario");
		}		
	}
}
