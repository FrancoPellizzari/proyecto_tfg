package com.edix.eventos.modelo.dao;

import com.edix.eventos.modelo.entities.Evento;

public interface EventoDao {

	Evento findById(int idEvento);
	boolean registro(Evento evento);
	Evento buscarUno(int idEvento);
	
}
