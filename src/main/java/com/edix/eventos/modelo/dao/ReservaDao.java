package com.edix.eventos.modelo.dao;

import java.util.List;

import com.edix.eventos.modelo.entities.Reserva;


public interface ReservaDao {
	
	Reserva buscarUno(int idReserva);
	List<Reserva> buscarTodos();
	int borrarReserva(int idReserva);
	int modificarReserva(Reserva reserva);
	int altaReserva(Reserva reserva);

}
