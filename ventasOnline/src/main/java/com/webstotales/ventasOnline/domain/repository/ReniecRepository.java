/**
 * Created By: JEXTM 27 set. 2016
 */
package com.webstotales.ventasOnline.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webstotales.ventasOnline.domain.Reniec;

/**
 * @author JEXTM
 *
 */
@Repository
public interface ReniecRepository extends JpaRepository<Reniec, Integer>{

}
