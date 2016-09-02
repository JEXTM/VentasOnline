/**
 * Created By: JEXTM 2 set. 2016
 */
package com.webstotales.ventasOnline.domain.repository;

import org.springframework.stereotype.Repository;

import com.webstotales.ventasOnline.domain.Test;

import org.springframework.data.jpa.repository.JpaRepository;
/**
 * @author JEXTM
 *
 */
@Repository
public interface TestRepository extends JpaRepository<Test, Integer>{
	
	/**
	 * Generate By: JEXTM 2 set. 2016
	 */
}
