package com.edix.eventos.modelo.dao;

import java.util.List;

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

	@Override
	public boolean guardar(Perfile perfil) {
		if (findById(perfil.getIdPerfil()) == null) {
			perfilRepo.save(perfil);
			return true;
		}
		return false;
		
	}

	@Override
	public List<Perfile> obtenerTodos() {
		// TODO Auto-generated method stub
		return perfilRepo.findAll();
	}

	@Override
	public void eliminar(int idPerfil) {
		// TODO Auto-generated method stub
		perfilRepo.deleteById(idPerfil);
	}

	@Override
	public Perfile actualizar(Perfile perfil) {
		// TODO Auto-generated method stub
		return perfilRepo.save(perfil);
	}
	
	@Override
	public Perfile altaPerfil(Perfile perfil) {
		// TODO Auto-generated method stub
		return perfilRepo.save(perfil);
	}

}
