package com.edix.eventos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edix.eventos.modelo.dao.PerfilDao;
import com.edix.eventos.modelo.entities.Evento;
import com.edix.eventos.modelo.entities.Perfile;

@Controller
@RequestMapping("/app/perfil")
public class PerfilController {
	
	@Autowired
	private PerfilDao perfilRepo;
	
	@GetMapping("/todos") 
	public String todosUsuarios(Model model) {
		model.addAttribute("mensaje", "Listado de perfiles");
		return "pruebas";
	}
	
	@GetMapping ("/verUno/{idPerfil}")
	public Perfile buscarUno (@PathVariable ("idPerfil") int idPerfil){
		return perfilRepo.findById(idPerfil);
		
	}
	
	@PostMapping ("/alta")
	public String altaPerfil (@RequestBody Perfile perfil) {
		if (perfilRepo.altaPerfil(perfil) != null) {
			return "Evento dado de alta";
		}else return "Evento no dado de alta";
		
	}
	
	@PutMapping ("/modificar")
	public String modificarPerfil (@RequestBody Perfile perfil) {
		if (perfilRepo.actualizar(perfil) != null) {
			return "Evento modificado correctamente";
		}else return "Evento no modificado";
	}
	
	@DeleteMapping ("/eliminar/{idPerfil}")
	public String eliminarPerfil (@PathVariable ("idPerfil") int idPerfil) {
		perfilRepo.eliminar(idPerfil);
		return "Perfil eliminado";
	}

}
