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
	
	@Override
	public Usuario modificarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return usuarioRepo.save(usuario);
	}

	@Override
	public void eliminarUsuario(String username) {
		
		usuarioRepo.eliminarUsuario(username);
	}
	
	@Override
	public Usuario altaUsuario(Usuario usuario) {
		
		return usuarioRepo.save(usuario);
	}
	
	public Usuario buscarUno(String username) {
		return usuarioRepo.findById(username);
	}
	@Override
	public Usuario findById(String username) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
