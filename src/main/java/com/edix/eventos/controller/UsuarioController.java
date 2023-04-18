package com.edix.eventos.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edix.eventos.dto.RegistroUsuarioDTO;
import com.edix.eventos.modelo.dao.PerfilDao;
import com.edix.eventos.modelo.dao.UsuarioDao;
import com.edix.eventos.modelo.entities.Evento;
import com.edix.eventos.modelo.entities.Usuario;
import com.edix.eventos.repository.UsuarioRepository;



@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepo;
	@Autowired
	UsuarioDao usuarioDaoRepo;
	@Autowired
	PerfilDao perfilRepo;
	
	@ModelAttribute("usuario")
	public RegistroUsuarioDTO retornaUsuarioRegistroDTO() {
		return new RegistroUsuarioDTO();
		
	}
	
	@GetMapping("/registro")
	public String registrarUsuario(Model model) {
		return "registro";
	}
	
	
	@GetMapping("/login")
	public String mostrarlogin() {
		
		return "login";
	
	}
	
		@PostMapping("/login")
		public String login(jakarta.servlet.http.HttpServletRequest request, HttpSession session) {
			String email = request.getParameter("email");
			String password = request.getParameter("password");

			Usuario usuario = usuarioDaoRepo.findUser(email, password);

			

			return "index";
		
		}
		
		@GetMapping("/salir")
		public String cerrarSesion(HttpSession session) {

			session.invalidate();

			return "redirect:/usuario/login";
		}
		
		@GetMapping ("/verUno/{username}")
		public Usuario buscarUno (@PathVariable ("username") String username){
			return usuarioRepo.buscarUno(username);
			
		}
		
		@PostMapping ("/alta")
		public String altaUsuario (@RequestBody Usuario usuario) {
			if (usuarioRepo.altaUsuario(usuario) != null) {
				return "Usuario dado de alta";
			}else return "Usuario no dado de alta";
			
		}
		
		@PutMapping ("/modificar")
		public String modificarUsuario (@RequestBody Usuario usuario) {
			if (usuarioRepo.modificarUsuario(usuario) != null) {
				return "Evento modificado correctamente";
			}else return "Evento no modificado";
		}
		
		@DeleteMapping ("/eliminar/{username}")
		public String eliminarsUsuario (@PathVariable ("username") String username) {
			usuarioRepo.eliminarUsuario(username);
			return "Usuario eliminado";
		}
	
	
	
}
