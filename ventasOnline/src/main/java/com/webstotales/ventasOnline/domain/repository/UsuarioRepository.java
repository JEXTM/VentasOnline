/**
 * Created By: JEXTM 5 set. 2016
 */
package com.webstotales.ventasOnline.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.webstotales.ventasOnline.domain.Usuario;

/**
 * @author JEXTM
 *
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	@Query("select count(u) from Usuario u where u.usuario = ?1")
	Long countUsername(String username);
	
	@Query("select u from Usuario u where u.usuario =?1 and u.contrasena = ?2")
	Usuario login(String usernmae, String password);
}
