/**
 * Created By: JEXTM 22 set. 2016
 */
package com.webstotales.ventasOnline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webstotales.ventasOnline.domain.Comida;
import com.webstotales.ventasOnline.domain.repository.ComidaRepository;

/**
 * @author JEXTM
 *
 */
@Service
public class ManagePlatosService {
	/**
	 * Generate By: JEXTM 22 set. 2016
	 */
	@Autowired
	private ComidaRepository comidaRepo;
	
	@Transactional(readOnly=true)
	public List<Comida> findAll(){
		return comidaRepo.findAll();
	}
	@Transactional
	public Comida save(Comida comida){
		return comidaRepo.saveAndFlush(comida);
	}
	@Transactional(readOnly=true)
	public Comida findById(Integer idComida){
		return comidaRepo.findOne(idComida);
	}
	
}
