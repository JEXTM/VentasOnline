package com.webstotales.ventasOnline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webstotales.ventasOnline.domain.Comida;
import com.webstotales.ventasOnline.domain.repository.ComidaRepository;

@Service
public class ManageComidaService {
	
	
	@Autowired
	private ComidaRepository comidaRepository;
	
	
	@Transactional(readOnly=true)
	public List<Comida> findAll(){
		return comidaRepository.findAll();
	}
	
	@Transactional(readOnly=true)
	public Comida findOne(Integer idComida){
		return  comidaRepository.findOne(idComida);
	}
	
	
}
