package com.webstotales.ventasOnline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webstotales.ventasOnline.domain.EstadoPedido;
import com.webstotales.ventasOnline.domain.repository.EstadoPedidoRepository;

@Service
public class ManageEstadoPedidoService {
	
	@Autowired
	private EstadoPedidoRepository estadoPedidoRepository;
	
	@Transactional(readOnly=true)
	public List<EstadoPedido> findAll(){
		return estadoPedidoRepository.findAll();
	}
}
