/**
 * Created By: JEXTM 26 set. 2016
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
@Table(name="t_distrito")
public class Distrito {
	/**
	 * Generate By: JEXTM 26 set. 2016
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idDistrito;
	@Column(name="nombre")
	private String nombre;
	public Integer getIdDistrito() {
		return idDistrito;
	}
	public void setIdDistrito(Integer idDistrito) {
		this.idDistrito = idDistrito;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @param idDistrito
	 * @param nombre
	 */
	public Distrito(Integer idDistrito, String nombre) {
		super();
		this.idDistrito = idDistrito;
		this.nombre = nombre;
	}
	
	/**
	 * 
	 */
	public Distrito() {
		// TODO Auto-generated constructor stub
	}
}
