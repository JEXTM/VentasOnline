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
@Table(name="t_rol")
public class Rol {
	/**
	 * Generate By: JEXTM 26 set. 2016
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idRol;
	@Column(name="descripcion")
	private String descripcion;
	@Column(name="estado")
	private Character estado;
	public Integer getIdRol() {
		return idRol;
	}
	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Character getEstado() {
		return estado;
	}
	public void setEstado(Character estado) {
		this.estado = estado;
	}
	/**
	 * @param idRol
	 * @param descripcion
	 * @param estado
	 */
	public Rol(Integer idRol, String descripcion, Character estado) {
		super();
		this.idRol = idRol;
		this.descripcion = descripcion;
		this.estado = estado;
	}
	
	/**
	 * 
	 */
	public Rol() {
		// TODO Auto-generated constructor stub
	}
}
