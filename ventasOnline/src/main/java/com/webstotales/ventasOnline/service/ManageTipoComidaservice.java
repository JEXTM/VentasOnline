package com.webstotales.ventasOnline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webstotales.ventasOnline.domain.TipoComida;
import com.webstotales.ventasOnline.domain.repository.TipoComidaRepository;

@Service
public class ManageTipoComidaservice {
	
	@Autowired
	private TipoComidaRepository tipoComidaRepository;
	
	
	@Transactional(readOnly=true)
	public List<TipoComida> findAll(){
		return tipoComidaRepository.findAll();
	}
}
