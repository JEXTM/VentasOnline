/**
 * Created By: JEXTM 3 oct. 2016
 */
package com.webstotales.ventasOnline.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.webstotales.ventasOnline.domain.Carrito;

/**
 * @author JEXTM
 *
 */
@Repository
public interface CarritoRepository extends JpaRepository<Carrito, Integer>{

	@Query("select count(u) from Carrito u where u.usuario = ?1")
	Long countById(Integer idUsuario);
	
	@Transactional
	@Modifying
	@Query("delete from Carrito u where u.usuario=?1")
	void deleteByUser(Integer idUsuario);
	
	@Query("select u from Carrito u where u.usuario = ?1")
	List<Carrito> findByIdUsuario(Integer idUsuario);
}
