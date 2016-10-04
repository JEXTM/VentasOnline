/**
 * Created By: JEXTM 26 set. 2016
 */
package com.webstotales.ventasOnline.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webstotales.ventasOnline.domain.Rol;

/**
 * @author JEXTM
 *
 */
@Repository
public interface RolRepository extends JpaRepository<Rol, Integer>{

}
