/**
 * Created By: JEXTM 26 oct. 2016
 */
package com.webstotales.ventasOnline.domain.model;

import com.webstotales.ventasOnline.domain.Comida;

/**
 * @author JEXTM
 *
 */
public class ComidaFrecuenteModel {
	/**
	 * Generate By: JEXTM 26 oct. 2016
	 */
	private Comida comida;
	private Long cantidad;
	public Comida getComida() {
		return comida;
	}
	public void setComida(Comida comida) {
		this.comida = comida;
	}
	public Long getCantidad() {
		return cantidad;
	}
	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}
	/**
	 * @param comida
	 * @param cantidad
	 */
	public ComidaFrecuenteModel(Comida comida, Long cantidad) {
		super();
		this.comida = comida;
		this.cantidad = cantidad;
	}
	
	/**
	 * 
	 */
	public ComidaFrecuenteModel() {
		// TODO Auto-generated constructor stub
	}
}
