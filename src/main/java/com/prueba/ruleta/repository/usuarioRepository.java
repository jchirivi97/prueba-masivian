package com.prueba.ruleta.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.prueba.ruleta.model.usuario;

public interface usuarioRepository extends JpaRepository<usuario,Integer> {

	@Query(value="select u.documento,u.apellido,u.credito,u.nombre,u.password,u.rol from usuario u where u.documento = ?1 and u.password = ?2",nativeQuery=true)
	usuario loginUser(int id,String password);
	
	
	@Transactional
	@Modifying
	@Query("update usuario u set u.credito=?2 where u.id=?1")
	void updateCredito(int id,int credito);
}
