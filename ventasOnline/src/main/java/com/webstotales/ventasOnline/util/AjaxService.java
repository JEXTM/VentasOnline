/**
 * Created By: JEXTM 2 set. 2016
 */
package com.webstotales.ventasOnline.util;

import java.util.List;

import com.webstotales.ventasOnline.domain.Detalle_Pedido;
import com.webstotales.ventasOnline.domain.Pedido;
import com.webstotales.ventasOnline.domain.model.Detalle_Pedido_Model;

/**
 * @author JEXTM
 *
 */
public interface AjaxService {
	public int getOne();
	public Long getPedEstadoCount(Integer estado);
	//public List<Detalle_Pedido_Model> getDetallePedido(Integer idPedido);
	public List<Pedido> getPedidoByEstado(Integer estado);
	public Integer updateEstado(Integer estado, Integer idPedido);
	public Long countByUsuario(Integer idUsuario);
	public void insertCarrito(Integer idUsuario, Integer idComida);
	public void borrarCarrito(Integer idCarrito);
	public List<Detalle_Pedido> getDetallePedido(Integer idPedido);
}
