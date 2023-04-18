package com.edix.eventos.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


import com.edix.eventos.modelo.dao.ReservaDao;
import com.edix.eventos.modelo.dao.ReservaDao;
import com.edix.eventos.modelo.entities.Reserva;


@Controller
@RequestMapping("/reservas")
public class ReservaController {
	
	@Autowired 
	ReservaDao reservaDao;
	
	@GetMapping ("/verUno/{idReserva}")
	public Reserva buscarReserva(@PathVariable ("idReserva") int idReserva){
		return reservaDao.buscarUno(idReserva);
		
	}
	
	@PostMapping ("/alta")
	public String altaReserva (@RequestBody Reserva reserva) {
		if (reservaDao.altaReserva(reserva) != 0) {
			return "Reserva dada de alta";
		}else return "Reserva no dada de alta";
		
	}
	
	@PutMapping ("/modificar")
	public String modificarReserva (@RequestBody Reserva reserva) {
		if (reservaDao.modificarReserva(reserva) != 0) {
			return "Reserva modificado correctamente";
		}else return "Reserva no modificado";
	}
	
	@DeleteMapping ("/eliminar/{idReserva}")
	public String eliminarReserva (@PathVariable ("idReserva") int idReserva) {
		reservaDao.borrarReserva(idReserva);
		return "Reserva eliminado";
	}
	
//	@GetMapping ("/plazasQuedan/{idReserva}")
//	public Map <String, Integer> plazasQuedan(@PathVariable ("idReserva") int idReserva){
//		Reserva r = reservaDao.buscarUno(idReserva);
//		int ocupadas = reservaDao.plazasocupadas(idReserva);
//		int respuesta= r.getAforoMax()-ocupadas;
//		Map <String, Integer> m= new HashMap<String, Integer>();
//		m.put("plazas_quedan", respuesta);
//		return m;
//	}

}
