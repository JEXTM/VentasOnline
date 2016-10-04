/**
 * Created By: JEXTM 3 oct. 2016
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
@Table(name="t_carrito")
public class Carrito {
	/**
	 * Generate By: JEXTM 3 oct. 2016
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idCarrito;
	@Column(name="idUsuario")
	private Integer usuario;
	@Column(name="idComida")
	private Integer comida;
	public Integer getIdCarrito() {
		return idCarrito;
	}
	public void setIdCarrito(Integer idCarrito) {
		this.idCarrito = idCarrito;
	}
	public Integer getUsuario() {
		return usuario;
	}
	public void setUsuario(Integer usuario) {
		this.usuario = usuario;
	}
	public Integer getComida() {
		return comida;
	}
	public void setComida(Integer comida) {
		this.comida = comida;
	}
	/**
	 * @param idCarrito
	 * @param usuario
	 * @param comida
	 */
	public Carrito(Integer idCarrito, Integer usuario, Integer comida) {
		super();
		this.idCarrito = idCarrito;
		this.usuario = usuario;
		this.comida = comida;
	}
	
	
	/**
	 * 
	 */
	public Carrito() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param usuario
	 * @param comida
	 */
	public Carrito(Integer usuario, Integer comida) {
		super();
		this.usuario = usuario;
		this.comida = comida;
	}
	
}
