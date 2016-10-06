/**
 * Created By: JEXTM 2 set. 2016
 */
package com.webstotales.ventasOnline.util.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.webstotales.ventasOnline.domain.Carrito;
import com.webstotales.ventasOnline.domain.Detalle_Pedido;
import com.webstotales.ventasOnline.domain.EstadoPedido;
import com.webstotales.ventasOnline.domain.Pedido;
import com.webstotales.ventasOnline.domain.model.Detalle_Pedido_Model;
import com.webstotales.ventasOnline.domain.repository.CarritoRepository;
import com.webstotales.ventasOnline.domain.repository.Detalle_pedidoRepository;
import com.webstotales.ventasOnline.domain.repository.PedidoRepository;
import com.webstotales.ventasOnline.util.AjaxService;

/**
 * @author JEXTM
 *
 */
public class AjaxServiceImpl implements AjaxService{
	@Autowired
	PedidoRepository pedidoRepository;
	
	@Autowired
	CarritoRepository carritoRepository;
	
	@Autowired
	Detalle_pedidoRepository detallePedidoRepository;
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
	public Long getPedEstadoCount(Integer estado) {
		return pedidoRepository.getEstadoCount(estado);
	}
	/* 
	 * Descripcion: 
	 *	@param :
	 */
//	@Override
//	@Transactional(readOnly=true)
//	public List<Detalle_Pedido_Model> getDetallePedido(Integer idPedido) {
//		return pedidoRepository.getDetallePedido(idPedido);
//	}
	/* 
	 * Descripcion: 
	 *	@param :
	 */
	@Override
	@Transactional(readOnly=true)
	public List<Pedido> getPedidoByEstado(Integer estado) {
		return pedidoRepository.getByEstado(estado);
	}
	@Transactional
	public Integer updateEstado(Integer estado, Integer idPedido){
		
		return pedidoRepository.updateEstado(estado, idPedido);
	}
	/* 
	 * Descripcion: 
	 *	@param :
	 */
	@Override
	@Transactional(readOnly=true)
	public Long countByUsuario(Integer idUsuario) {
		// TODO Auto-generated method stub
		return carritoRepository.countById(idUsuario);
	}
	/* 
	 * Descripcion: 
	 *	@param :
	 */
	@Override
	@Transactional
	public void insertCarrito(Integer idUsuario, Integer idComida) {
		Carrito carrito = new Carrito(idUsuario, idComida);
		carritoRepository.saveAndFlush(carrito);
	}
	@Override
	@Transactional
	public void borrarCarrito(Integer idCarrito) {
		carritoRepository.delete(idCarrito);
	}
	@Override
	@Transactional(readOnly=true)
	public List<Detalle_Pedido> getDetallePedido(Integer idPedido) {
		return detallePedidoRepository.getById(idPedido);
	}
	
}
