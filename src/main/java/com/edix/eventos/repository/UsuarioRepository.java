package com.edix.eventos.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.edix.eventos.modelo.entities.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

	
}
