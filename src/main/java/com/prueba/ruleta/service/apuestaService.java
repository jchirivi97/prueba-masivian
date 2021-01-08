package com.prueba.ruleta.service;

import java.util.List;

import com.prueba.ruleta.model.apuesta;

public interface apuestaService {
	
	List<apuesta> saveApuesta(apuesta bet) throws Exception;
	
}
