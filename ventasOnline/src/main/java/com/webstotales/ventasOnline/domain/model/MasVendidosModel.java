/**
 * Created By: JEXTM 23 oct. 2016
 */
package com.webstotales.ventasOnline.domain.model;

/**
 * @author JEXTM
 *
 */
public class MasVendidosModel {
	/**
	 * Generate By: JEXTM 23 oct. 2016
	 */
	
	private Integer idComida;
	private long count;
	public Integer getIdComida() {
		return idComida;
	}
	public void setIdComida(Integer idComida) {
		this.idComida = idComida;
	}
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
	/**
	 * @param idComida
	 * @param count
	 */
	public MasVendidosModel(Integer idComida, long count) {
		super();
		this.idComida = idComida;
		this.count = count;
	}
	
	/**
	 * 
	 */
	public MasVendidosModel() {
		// TODO Auto-generated constructor stub
	}
}
