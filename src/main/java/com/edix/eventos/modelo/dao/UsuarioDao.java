package com.edix.eventos.modelo.dao;

import com.edix.eventos.dto.RegistroUsuarioDTO;
import com.edix.eventos.modelo.entities.Evento;
import com.edix.eventos.modelo.entities.Usuario;

public interface UsuarioDao {
	
	Usuario findById(String username);
	boolean registro(Usuario usuario);
	Usuario guardar(RegistroUsuarioDTO registroDTO);
	Usuario findUser(String email, String password);
	Usuario altaUsuario (Usuario evento);
	Usuario modificarUsuario (Usuario usuario);
	void eliminarUsuario (String username);

}
