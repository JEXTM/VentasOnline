/**
 * Created By: JEXTM 5 set. 2016
 */
package com.webstotales.ventasOnline.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.webstotales.ventasOnline.domain.Comida;

/**
 * @author JEXTM
 *
 */
@Repository
public interface ComidaRepository extends JpaRepository<Comida, Integer>{
	@Query("select u from Comida u where u.tipoComida.id = ?1")
	List<Comida> findByType(Integer idTipo);
}
