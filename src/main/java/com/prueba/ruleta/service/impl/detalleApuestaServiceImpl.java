package com.prueba.ruleta.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.ruleta.model.detalleApuesta;
import com.prueba.ruleta.repository.detalleApuestaRepository;
import com.prueba.ruleta.service.detalleApuestaService;

@Service
public class detalleApuestaServiceImpl implements detalleApuestaService {
	
	@Autowired
	detalleApuestaRepository detalleRep;

	@Override
	public void saveDetalle(detalleApuesta detalle) throws Exception {
		try{
			detalleRep.save(detalle);
		}catch(Exception e){
			throw new Exception("No se puede almacenar la apuesta");
		}		
	}

}
