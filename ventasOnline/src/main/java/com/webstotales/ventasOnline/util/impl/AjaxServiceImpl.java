/**
 * Created By: JEXTM 2 set. 2016
 */
package com.webstotales.ventasOnline.util.impl;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.webstotales.ventasOnline.domain.Carrito;
import com.webstotales.ventasOnline.domain.Detalle_Pedido;
import com.webstotales.ventasOnline.domain.Distrito;
import com.webstotales.ventasOnline.domain.Pedido;
import com.webstotales.ventasOnline.domain.Rol;
import com.webstotales.ventasOnline.domain.Usuario;
import com.webstotales.ventasOnline.domain.model.Detalle_Pedido_Model;
import com.webstotales.ventasOnline.domain.repository.CarritoRepository;
import com.webstotales.ventasOnline.domain.repository.Detalle_pedidoRepository;
import com.webstotales.ventasOnline.domain.repository.PedidoRepository;
import com.webstotales.ventasOnline.domain.repository.UsuarioRepository;
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
	
	@Autowired
	UsuarioRepository usuariorepository;
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

	@Transactional
	public List<Detalle_Pedido_Model> getDetallePedido(Integer idPedido) {
		List<Detalle_Pedido> pedidos = detallePedidoRepository.getById(idPedido);
		List<Detalle_Pedido_Model> pedidosReturn = new ArrayList<Detalle_Pedido_Model>();
		for (Detalle_Pedido detalle_Pedido : pedidos) {
			if (detalle_Pedido!=null) {
			Detalle_Pedido_Model detPedido = new Detalle_Pedido_Model();
			detPedido.setIdPedido(detalle_Pedido.getPk().getPedido().getIdPedido());
			detPedido.setApellido(detalle_Pedido.getPk().getPedido().getUsuario().getApellidoPat() + " "+ detalle_Pedido.getPk().getPedido().getUsuario().getApellidoMat());
			detPedido.setCantidad(detalle_Pedido.getUnidades());
			detPedido.setComida(detalle_Pedido.getPk().getComida().getNombre());
			detPedido.setDirrecion(detalle_Pedido.getPk().getPedido().getUsuario().getDireccion());
			detPedido.setEstado(detalle_Pedido.getPk().getPedido().getEstado().getDescripcion());
			detPedido.setFecha(detalle_Pedido.getPk().getPedido().getFecha());
			detPedido.setImporte(detalle_Pedido.getPk().getPedido().getImporte());
			detPedido.setNombre(detalle_Pedido.getPk().getPedido().getUsuario().getNombre());
			detPedido.setPrecio(detalle_Pedido.getPrecio());
			pedidosReturn.add(detPedido);
			}
		}
		return pedidosReturn;
	}
	/* 
	 * Descripcion: 
	 *	@param :
	 */
	@Override
	public Integer cambiarEstadoPedido(Integer estado,Integer idPedido) {
		return pedidoRepository.updateEstado(estado, idPedido);
	}
	/* 
	 * Descripcion: 
	 *	@param :
	 */
	@Override
	public List<Object> getDetalleById(Integer idPedido) {
		return detallePedidoRepository.getDetalleById(idPedido);
	}
	@Override
	public Integer saveUsuario(String nombre, String apePat, String apeMat, Integer dni, String email, String direccion,
			String usuario, String contra, Double peso, Double talla, Character sexo, String celular, String fechaNac) {
		int ano = Integer.parseInt(fechaNac.substring(6));
		int mes = Integer.parseInt(fechaNac.substring(3, 5));
		int dia = Integer.parseInt(fechaNac.substring(0, 2));
		@SuppressWarnings("deprecation")
		Date fechaNacimiento = new Date((ano-1900), mes, dia);
		Usuario user = new Usuario(nombre, apeMat, apeMat, direccion, "1", sexo, fechaNacimiento, celular, email, "", new Distrito(1, ""), peso, talla,((peso/Math.pow(talla, 2.0))), dni, usuario, contra, 'A', new Rol(1,"",'A'));
		try{
		usuariorepository.saveAndFlush(user);
		}catch (Exception e) {
			return 0;
		}
		return 1;
	}
	
}
