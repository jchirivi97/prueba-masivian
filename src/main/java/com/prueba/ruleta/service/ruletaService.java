package com.prueba.ruleta.service;

import java.util.List;

import com.prueba.ruleta.model.ruleta;

public interface ruletaService {
	
	int newRuleta (ruleta roulette) throws Exception;
	
	boolean openRuleta(ruleta roulette) throws Exception;
	
	List<ruleta> allRuletas()throws Exception;
	
	ruleta getRuleta(int id) throws Exception;
}
