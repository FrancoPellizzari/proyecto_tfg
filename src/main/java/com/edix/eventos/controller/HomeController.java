package com.edix.eventos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.edix.eventos.modelo.dao.EventoDao;
import com.edix.eventos.modelo.dao.UsuarioDao;

@Controller
public class HomeController {
	@Autowired
	EventoDao eventoRepo;
	
	@Autowired
	UsuarioDao usuarioRepo;
	
	

}
