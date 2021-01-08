package com.prueba.ruleta.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.ruleta.model.ruleta;
import com.prueba.ruleta.repository.ruletaRepository;
import com.prueba.ruleta.service.ruletaService;

@Service
public class ruletaServiceImpl implements ruletaService {
	
	@Autowired
	ruletaRepository ruletaRep;

	/**
	 * Method for to create a new roulette
	 * @param roulette Object of type ruleta
	 * @return id of the roulette created
	 */
	@Override
	public int newRuleta(ruleta roulette) throws Exception{
		try{
			ruletaRep.save(roulette);
			List<ruleta> ruletas = allRuletas();
			return ruletas.get(ruletas.size()-1).getId();
		}catch(Exception e){
			throw new Exception("No es posible crear la ruleta");
		}
	}

	/**
	 * Method for to open roulette, it changing the status
	 * @param roulette Object of type ruleta
	 */
	@Override
	public boolean openRuleta(ruleta roulette) throws Exception {
		boolean status = false;
		try{
			ruletaRep.updateEstado(roulette.getEstado(), roulette.getId());
			status = true;
		}catch(Exception e){
			throw new Exception("No es posible aperturar la ruleta");
		}	
		return status;
	}

	/**
	 * Method for to view all roulettes opens or closes
	 * @return List of objects type ruleta
	 */
	@Override
	public List<ruleta> allRuletas() throws Exception{
		try{
			return ruletaRep.findAll();
		}catch(Exception e ){
			throw new Exception("No hay ruletas disponibles");
		}		
	}

	/**
	 * Method for to get the roulette selected
	 * @return ruleta
	 */
	@Override
	public ruleta getRuleta(int id) throws Exception {
		try{
			return ruletaRep.findById(id).get();
		}catch(Exception e){
			throw new Exception("No existe la ruleta");
		}
	}

}
