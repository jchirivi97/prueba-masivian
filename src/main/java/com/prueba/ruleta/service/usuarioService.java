package com.prueba.ruleta.service;

import com.prueba.ruleta.model.usuario;

public interface usuarioService {
	
	usuario getUser(int id) throws Exception;	
	usuario login(int id, String password) throws Exception;
	void saveUser(usuario user) throws Exception;
	void updateCredito(int id,int credito) throws Exception;
}
