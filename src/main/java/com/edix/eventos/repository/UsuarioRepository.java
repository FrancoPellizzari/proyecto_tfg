package com.edix.eventos.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.edix.eventos.modelo.entities.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	//@Query("select u from Usuario u where u.email = ?1 and u.password=?2")
	
		@Query(value = "select * from usuarios where email = :email and password = :password", nativeQuery = true)
		  Usuario findUsuario(@Param(value="email") String email, @Param(value="password") String password);
//		@Query("select u from Usuario u where u.id_usuario = ?1")
//			public List<Usuario> findById(int id_usuario);

		@Query("select u from Usuario u where u.email = ?1 and u.password =?2")
		public Usuario buscarPorEmail(String email,String password);
		
		Usuario altaUsuario(Usuario usuario);
		
		/*@Modifying
	    @Query("update Usuario u set u.nombre = :nombre, u.email = :email where u.id = :id")
	    void modificarUsuario(@Param("id") Long id, @Param("nombre") String nombre, 
	                          @Param("email") String email, @Param("edad") int edad);
	 */
		
		Usuario modificarUsuario(Usuario usuario);
		void eliminarUsuario(String username);
		Usuario buscarUno(String username);
		Usuario findById(String username);
	
}
