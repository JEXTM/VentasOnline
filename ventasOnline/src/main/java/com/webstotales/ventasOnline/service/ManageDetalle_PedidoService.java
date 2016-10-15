/**
 * Created By: JEXTM 11 set. 2016
 */
package com.webstotales.ventasOnline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webstotales.ventasOnline.domain.Detalle_Pedido;
import com.webstotales.ventasOnline.domain.repository.Detalle_pedidoRepository;

/**
 * @author JEXTM
 *
 */
@Service
public class ManageDetalle_PedidoService {
	/**
	 * Generate By: JEXTM 11 set. 2016
	 */
	@Autowired
	private Detalle_pedidoRepository detalle_pedidoRepository;
	
	
	@Transactional(readOnly=true)
	public List<Detalle_Pedido> getPedidoById(Integer idPedido){
		return detalle_pedidoRepository.getById(idPedido);
	}
	
	@Transactional
	public Detalle_Pedido save(Detalle_Pedido detalle_Pedido){
		return detalle_pedidoRepository.saveAndFlush(detalle_Pedido);
	}
	
}
