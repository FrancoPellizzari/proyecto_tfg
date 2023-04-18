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


import com.edix.eventos.modelo.dao.EventoDao;
import com.edix.eventos.modelo.dao.ReservaDao;
import com.edix.eventos.modelo.entities.Evento;


@Controller
@RequestMapping("/rest/eventos")
public class EventoController {
	
	@Autowired
	private EventoDao eventoRepo;
	
	@Autowired 
	ReservaDao reservaRepo;
	
	@GetMapping ("/activos")
	public List<Evento> eventosActivos (){
		return eventoRepo.eventoactivos();
	}
	
	@GetMapping ("/destacados")
	public List<Evento> eventosDestacados (){
		return eventoRepo.eventosdestacados();
	
	}
	
	@GetMapping ("/verUno/{idEvento}")
	public Evento buscarUno (@PathVariable ("idEvento") int idEvento){
		return eventoRepo.buscarUno(idEvento);
		
	}
	
	@PostMapping ("/alta")
	public String altaEvento (@RequestBody Evento evento) {
		if (eventoRepo.altaEvento(evento) != null) {
			return "Evento dado de alta";
		}else return "Evento no dado de alta";
		
	}
	
	@PutMapping ("/modificar")
	public String modificarEvento (@RequestBody Evento evento) {
		if (eventoRepo.modificarEvento(evento) != null) {
			return "Evento modificado correctamente";
		}else return "Evento no modificado";
	}
	
	@DeleteMapping ("/eliminar/{idEvento}")
	public String eliminarEvento (@PathVariable ("idEvento") int idEvento) {
		eventoRepo.eliminarEvento(idEvento);
		return "Evento eliminado";
	}
	
	@GetMapping ("/plazasQuedan/{idEvento}")
	public Map <String, Integer> plazasQuedan(@PathVariable ("idEvento") int idEvento){
		Evento e = eventoRepo.buscarUno(idEvento);
		int ocupadas = reservaRepo.plazasocupadas(idEvento);
		int respuesta= e.getAforoMax()-ocupadas;
		Map <String, Integer> m= new HashMap<String, Integer>();
		m.put("plazas_quedan", respuesta);
		return m;
	}

}
