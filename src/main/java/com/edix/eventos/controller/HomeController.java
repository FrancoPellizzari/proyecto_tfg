package com.edix.eventos.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.edix.eventos.modelo.dao.EventoDao;
import com.edix.eventos.modelo.dao.PerfilDao;
import com.edix.eventos.modelo.dao.UsuarioDao;
import com.edix.eventos.modelo.entities.Evento;
import com.edix.eventos.modelo.entities.Usuario;





@Controller
public class HomeController {
	@Autowired
	EventoDao eventoRepo;
	
	@Autowired
	UsuarioDao usuarioRepo;
	
	@Autowired
	PerfilDao perfilRepo;
	
	
	@GetMapping("login")
	public String login(HttpSession session) {
		return "index";
	}

	@PostMapping("login")
	public String login(HttpServletRequest request, HttpSession session, Model model) {
		String username = String.valueOf(request.getParameter("usuario"));

		// Buscamos la cuenta por su id
		Optional<Usuario> optUsuario = Optional.ofNullable(usuarioRepo.findById(username));

		// Comprobamos si la cuenta existe
		if (optUsuario.isPresent()) {
			session.setAttribute("username", username);

			return "redirect:/menu";
		} else {
			model.addAttribute("mensajeError", "No se ha encontrado el usuario introducido");
			return "index";
		}

	}
	
	@GetMapping("ingresar")
	public String mostrarReservas(HttpSession session) {
		// Comprobar que el usuario está logado
		if (session.getAttribute("username") == null) {
			return "index";
		} else {
			return "reservas";
		}

	}
	
	@GetMapping("menu")
	public String mostrarMenu(HttpSession session) {
		// Comprobar que el usuario está logado
		if (session.getAttribute("username") == null) {
			return "index";
		} else {
			return "menu";
		}

	}
	
	@GetMapping("/eventos")
	public String verTodos(Model model) {
		
	//	System.out.println(aut.getName() + "  -  " + aut.getAuthorities());
		List<Evento> lista = eventoRepo.mostrarTodos();
		model.addAttribute("listaTodos", lista);
		
		return "listaTodos";
		 
		
	}
	
	@PostMapping("/registro")
	public String proregistrar(Model model, Usuario usuario, RedirectAttributes ratt) {
		
		usuario.setEnabled(1);
		usuario.setFechaRegistro(new Date());
	 	usuario.addPerfil(perfilRepo.findById(3));
	 	usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
	 	
	 	if (usuarioRepo.registro(usuario)) {
	 		ratt.addFlashAttribute("mensaje", "alta realizada");
	 		return "redirect:/login";
	 	}
	 	else {
	 		model.addAttribute("mensaje", "ya existe como usuario");
	 		return "/registro";
	 		
	 	}
		
	}
	
	
	

}
