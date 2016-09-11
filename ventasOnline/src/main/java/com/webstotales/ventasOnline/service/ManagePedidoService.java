/**
 * Created By: JEXTM 10 set. 2016
 */
package com.webstotales.ventasOnline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webstotales.ventasOnline.domain.Pedido;
import com.webstotales.ventasOnline.domain.repository.PedidoRepository;

/**
 * @author JEXTM
 *
 */
@Service
public class ManagePedidoService{
	/**
	 * Generate By: JEXTM 10 set. 2016
	 */
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Transactional(readOnly=true)
	public Long getIngresados(){
		return pedidoRepository.getEstadoCount('I');
	}
	
	@Transactional(readOnly=true)
	public List<Pedido> getByEstado(Character estado){
		return pedidoRepository.getByEstado(estado);
	}
	@Transactional(readOnly=true)
	public Pedido findById(Integer id){
		return pedidoRepository.findOne(id);
	}
}
