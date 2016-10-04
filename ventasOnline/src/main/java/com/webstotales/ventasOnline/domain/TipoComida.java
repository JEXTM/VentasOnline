/**
 * Created By: JEXTM 1 oct. 2016
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
@Table(name="t_tipoComida")
public class TipoComida {
	/**
	 * Generate By: JEXTM 1 oct. 2016
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name="nombre")
	private String nombre;
	@Column(name="tipo")
	private String tipo;
	@Column(name="abreviatura")
	private String abreviatura;
	@Column(name="estado")
	private Boolean estado;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getAbreviatura() {
		return abreviatura;
	}
	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
	/**
	 * 
	 */
	public TipoComida() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param id
	 * @param nombre
	 * @param tipo
	 * @param abreviatura
	 * @param estado
	 */
	public TipoComida(Integer id, String nombre, String tipo, String abreviatura, Boolean estado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
		this.abreviatura = abreviatura;
		this.estado = estado;
	}
	
	
}
