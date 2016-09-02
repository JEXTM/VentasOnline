/**
 * Created By: JEXTM 2 set. 2016
 */
package com.webstotales.ventasOnline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webstotales.ventasOnline.domain.Test;
import com.webstotales.ventasOnline.domain.repository.TestRepository;

/**
 * @author JEXTM
 *
 */
@Service
public class ManageTestService {
	/**
	 * Generate By: JEXTM 2 set. 2016
	 */
	@Autowired
	private TestRepository testRepository;
	
	@Transactional(readOnly=true)
	public List<Test> getAll(){
		return testRepository.findAll();
	}
	
}
