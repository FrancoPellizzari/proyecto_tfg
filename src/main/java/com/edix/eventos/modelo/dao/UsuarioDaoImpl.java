package com.edix.eventos.modelo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edix.eventos.dto.RegistroUsuarioDTO;
import com.edix.eventos.modelo.entities.Usuario;
import com.edix.eventos.repository.UsuarioRepository;

@Repository
public class UsuarioDaoImpl implements UsuarioDao {
	private List<Usuario>listaUsuarios;
	@Autowired
	UsuarioRepository usuarioRepo;
	@Override
	public Usuario buscarUno(String email) {
		// TODO Auto-generated method stub
		return usuarioRepo.findById(email).orElse(null);
	}
	@Override
	public boolean registro(Usuario usuario) {
		if(buscarUno(usuario.getEmail()) == null) {
			usuarioRepo.save(usuario);
			return true;
		}
		return false;
	}
	@Override
	public Usuario guardar(RegistroUsuarioDTO registroDTO) {
		Usuario usuario= new Usuario(registroDTO.getNombre(),
				registroDTO.getEmail(),
				registroDTO.getPassword());
		
		return usuarioRepo.save(usuario);
	}
	@Override
	public Usuario findUser(String email, String password) {
		
		return usuarioRepo.findUsuario(email,password);
	}
	
	

}
