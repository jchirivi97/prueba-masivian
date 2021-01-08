package com.prueba.ruleta.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.prueba.ruleta.model.ruleta;


public interface ruletaRepository extends JpaRepository<ruleta,Integer> {
	
	@Transactional
	@Modifying
	@Query("update ruleta r set r.estado=?1 where r.id=?2")
	void updateEstado(boolean estado,int id);
	
}
