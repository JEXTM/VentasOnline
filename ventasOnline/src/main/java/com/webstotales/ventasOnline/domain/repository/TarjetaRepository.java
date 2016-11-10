/**
 * Created By: JEXTM 27 oct. 2016
 */
package com.webstotales.ventasOnline.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.webstotales.ventasOnline.domain.Tarjeta;

/**
 * @author JEXTM
 *
 */
@Repository
public interface TarjetaRepository extends JpaRepository<Tarjeta, Integer>{
	
	@Query("select u from Tarjeta u where u.numero =?1")
	Tarjeta findByNumero(String numero);
	
	@Query("select u.tarjeta from Usuario u where u.idUsuario = ?1")
	Tarjeta getTarjetaByIdUsuario(Integer idUsuario);
}
