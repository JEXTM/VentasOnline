/**
 * Created By: JEXTM 5 set. 2016
 */
package com.webstotales.ventasOnline.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.webstotales.ventasOnline.domain.Cliente;

/**
 * @author JEXTM
 *
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

	@Query("select count(u) from Users u where u.username = ?1")
	public long countUsername(String username);
}
