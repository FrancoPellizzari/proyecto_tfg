package com.edix.eventos.modelo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edix.eventos.modelo.entities.Evento;
import com.edix.eventos.repository.EventoRepository;

@Repository
public class EventoDaoImpl implements EventoDao {
	@Autowired
	EventoRepository eventoRepo;
	
		@Override
		public Evento findById(int idEvento) {
		
		return eventoRepo.findById(idEvento).orElse(null);
	}
	@Override		
	public boolean registro(Evento evento) {
		
		if (buscarUno(evento.getIdEvento()) == null) {
			eventoRepo.save(evento);
			return true;
		}
		return false;
		
	}
	
	@Override
	public Evento buscarUno(int idEvento) {
		
		return eventoRepo.findById(idEvento).orElse(null);
	}

}
