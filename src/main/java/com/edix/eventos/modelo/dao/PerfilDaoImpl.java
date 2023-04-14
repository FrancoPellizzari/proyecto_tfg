package com.edix.eventos.modelo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.edix.eventos.modelo.entities.Perfile;
import com.edix.eventos.repository.PerfilRepository;

@Repository
public class PerfilDaoImpl implements PerfilDao {
	
	@Autowired
	PerfilRepository perfilRepo;
	
	@Override
	public Perfile findById(int idPerfil) {
		
		return perfilRepo.findById(idPerfil).orElse(null);
	}

}
