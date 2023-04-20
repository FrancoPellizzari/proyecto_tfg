package com.edix.eventos.modelo.dao;

import java.util.List;

import com.edix.eventos.modelo.entities.Perfile;

public interface PerfilDao {

	  Perfile findById(int idPerfil);
	  boolean guardar(Perfile perfil);
	  List<Perfile> obtenerTodos();
	  void eliminar(int idPerfil);
	  Perfile actualizar(Perfile perfil);
	  Perfile altaPerfil(Perfile perfil);
}
