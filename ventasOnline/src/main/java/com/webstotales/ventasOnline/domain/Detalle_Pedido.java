/**
 * Created By: JEXTM 9 set. 2016
 */
package com.webstotales.ventasOnline.domain;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import com.webstotales.ventasOnline.domain.ids.Detalle_PedidoId;

/**
 * @author JEXTM
 *
 */
@Entity
@Table(name="t_detalle_pedido")
@AssociationOverrides({
	@AssociationOverride(name = "pk.pedido",
		joinColumns = @JoinColumn(name = "idPedido")),
	@AssociationOverride(name = "pk.comida",
		joinColumns = @JoinColumn(name = "idComida")) })
public class Detalle_Pedido {
	/**
	 * Generate By: JEXTM 9 set. 2016
	 */
	@EmbeddedId
	private Detalle_PedidoId pk = new Detalle_PedidoId();
	@Column(name="unidades")
	private Integer unidades;
	@Column(name="estado")
	private boolean estado;
	/**
	 * @param pk
	 * @param unidades
	 * @param estado
	 */
	public Detalle_Pedido(Detalle_PedidoId pk, Integer unidades, boolean estado) {
		super();
		this.pk = pk;
		this.unidades = unidades;
		this.estado = estado;
	}
	public Detalle_PedidoId getPk() {
		return pk;
	}
	public void setPk(Detalle_PedidoId pk) {
		this.pk = pk;
	}
	public Integer getUnidades() {
		return unidades;
	}
	public void setUnidades(Integer unidades) {
		this.unidades = unidades;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	/**
	 * 
	 */
	public Detalle_Pedido() {
		
	}
	
	
}
