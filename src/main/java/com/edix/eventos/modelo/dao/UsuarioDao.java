package com.edix.eventos.modelo.dao;

import com.edix.eventos.dto.RegistroUsuarioDTO;
import com.edix.eventos.modelo.entities.Usuario;

public interface UsuarioDao {
	
	Usuario buscarUno(String email);
	boolean registro(Usuario usuario);
	Usuario guardar(RegistroUsuarioDTO registroDTO);
	Usuario findUser(String email, String password);

}
