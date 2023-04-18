package com.edix.eventos.modelo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.edix.eventos.modelo.entities.Reserva;
import com.edix.eventos.repository.ReservaRepository;

public class ReservaDaoImpl implements ReservaDao {
	
	@Autowired
	ReservaRepository reservaRepo;

	@Override
	public Reserva buscarUno(int idReserva) {
		// TODO Auto-generated method stub
		return reservaRepo.findById(idReserva).orElse(null);
	}

	@Override
	public List<Reserva> buscarTodos() {
		// TODO Auto-generated method stub
		return reservaRepo.findAll();
	}

	@Override
	public int borrarReserva(int idReserva) {
		
		int filas = 0;
		try {
			reservaRepo.deleteById(idReserva);
			filas=1;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return filas;
	}

	
	@Override
	public int modificarReserva(Reserva reserva) {
		
		int filas = 0;
		Reserva r1 = null;
		try {
			//r1=reservaRepo.getById(reserva.getIdReserva());
			//p1=reservaRepo.getOne(reserva.getIdReserva());
			r1=reserva;
			reservaRepo.save(r1);
			filas=1;
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return filas;
		
	}

	@Override
	public int altaReserva(Reserva reserva) {
		int filas =0;
		try {
			reservaRepo.save(reserva);
			filas=1;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public int plazasocupadas(int idEvento) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
