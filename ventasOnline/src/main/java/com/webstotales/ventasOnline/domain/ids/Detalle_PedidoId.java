/**
 * Created By: JEXTM 9 set. 2016
 */
package com.webstotales.ventasOnline.domain.ids;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import com.webstotales.ventasOnline.domain.Comida;
import com.webstotales.ventasOnline.domain.Pedido;

/**
 * @author JEXTM
 *
 */
@Embeddable
public class Detalle_PedidoId implements Serializable{
	/**
	 * Generate By: JEXTM 9 set. 2016
	 */
	@ManyToOne
	private Pedido pedido;
	@ManyToOne
	private Comida comida;
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	public Comida getComida() {
		return comida;
	}
	public void setComida(Comida comida) {
		this.comida = comida;
	}
	/**
	 * @param pedido
	 * @param comida
	 */
	public Detalle_PedidoId(Pedido pedido, Comida comida) {
		super();
		this.pedido = pedido;
		this.comida = comida;
	}
	
	/**
	 * 
	 */
	public Detalle_PedidoId() {

	}
	
	
}
