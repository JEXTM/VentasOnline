/**
 * Created By: JEXTM 2 set. 2016
 */
package com.webstotales.ventasOnline.util;

import java.util.List;

import com.webstotales.ventasOnline.domain.model.Detalle_Pedido_Model;

/**
 * @author JEXTM
 *
 */
public interface AjaxService {
	public int getOne();
	public Long getPedEstadoCount(Character estado);
	public List<Detalle_Pedido_Model> getDetallePedido(Integer idPedido);
}
