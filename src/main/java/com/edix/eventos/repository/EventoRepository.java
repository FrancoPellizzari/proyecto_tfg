package com.edix.eventos.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.edix.eventos.modelo.entities.Evento;



public interface EventoRepository extends JpaRepository<Evento, Integer>{

	
}
