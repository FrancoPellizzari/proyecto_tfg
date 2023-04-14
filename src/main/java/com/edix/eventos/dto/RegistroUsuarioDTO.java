package com.edix.eventos.dto;



public class RegistroUsuarioDTO {
	
	private String nombre;
	private String email;
	private String password;
	
	public RegistroUsuarioDTO(String nombre, String email, String password) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public RegistroUsuarioDTO() {
		super();
	}
	
	
	
	
	
	
	

}
