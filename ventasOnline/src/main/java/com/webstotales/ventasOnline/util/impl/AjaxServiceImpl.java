/**
 * Created By: JEXTM 2 set. 2016
 */
package com.webstotales.ventasOnline.util.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.webstotales.ventasOnline.domain.Pedido;
import com.webstotales.ventasOnline.domain.model.Detalle_Pedido_Model;
import com.webstotales.ventasOnline.domain.repository.PedidoRepository;
import com.webstotales.ventasOnline.util.AjaxService;

/**
 * @author JEXTM
 *
 */
public class AjaxServiceImpl implements AjaxService{
	@Autowired
	PedidoRepository pedidoRepository;
	
	/* 
	 * Descripcion: 
	 *	@param :
	 */
	@Override
	public int getOne() {
		return 1;
	}
	/**
	 * Generate By: JEXTM 2 set. 2016
	 */

	/* 
	 * Descripcion: 
	 *	@param :
	 */
	@Override
	@Transactional(readOnly=true)
	public Long getPedEstadoCount(Character estado) {
		return pedidoRepository.getEstadoCount(estado);
	}
	/* 
	 * Descripcion: 
	 *	@param :
	 */
	@Override
	@Transactional(readOnly=true)
	public List<Detalle_Pedido_Model> getDetallePedido(Integer idPedido) {
		return pedidoRepository.getDetallePedido(idPedido);
	}
	/* 
	 * Descripcion: 
	 *	@param :
	 */
	@Override
	@Transactional(readOnly=true)
	public List<Pedido> getPedidoByEstado(Character estado) {
		return pedidoRepository.getByEstado(estado);
	}
	
}
