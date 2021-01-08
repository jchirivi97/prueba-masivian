package com.prueba.ruleta.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.ruleta.model.apuesta;
import com.prueba.ruleta.repository.apuestaRepository;
import com.prueba.ruleta.service.apuestaService;

@Service
public class apuestaServiceImpl implements apuestaService{
	
	@Autowired
	apuestaRepository apuestaRep;

	/**
	 * Method for save bets made by the user
	 * @param bet object of type apuesta
	 */
	@Override
	public List<apuesta> saveApuesta(apuesta bet) throws Exception {
		try{
			apuestaRep.save(bet);
			return apuestaRep.findAll();
		}catch(Exception e){
			throw new Exception("No es posible realizar la apuesta");
		}		
	}

}
