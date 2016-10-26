/**
 * Created By: JEXTM 27 set. 2016
 */
package com.webstotales.ventasOnline.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author JEXTM
 *
 */
@Entity
@Table(name="t_estadopedido")
public class EstadoPedido {
	/**
	 * Generate By: JEXTM 27 set. 2016
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idPedido;
	@Column(name="descripcion")
	private String descripcion;
	public Integer getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/**
	 * @param idPedido
	 * @param descripcion
	 */
	public EstadoPedido(Integer idPedido, String descripcion) {
		super();
		this.idPedido = idPedido;
		this.descripcion = descripcion;
	}
	
	/**
	 * 
	 */
	public EstadoPedido() {
		// TODO Auto-generated constructor stub
	}
	
}
