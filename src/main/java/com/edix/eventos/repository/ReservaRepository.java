package com.edix.eventos.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.edix.eventos.modelo.entities.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Integer>{
	

}
