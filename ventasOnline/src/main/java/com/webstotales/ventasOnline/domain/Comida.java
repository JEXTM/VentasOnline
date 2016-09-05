/**
 * Created By: JEXTM 5 set. 2016
 */
package com.webstotales.ventasOnline.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author JEXTM
 *
 */
@Entity
@Table(name="t_comida")
public class Comida {
	/**
	 * Generate By: JEXTM 5 set. 2016
	 */
	@Id
	private Integer idComida;
	@Column(name="nombre",nullable=false)
	private String nombre;
	@Column(name="precio")
	private Double precio;
	@Column(name="url")
	private String url;
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy = "pk.comida")
	private Set<ComidaIngrediente> ingredientes = new HashSet<ComidaIngrediente>(0);
	public Integer getIdComida() {
		return idComida;
	}
	public void setIdComida(Integer idComida) {
		this.idComida = idComida;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Set<ComidaIngrediente> getIngredientes() {
		return ingredientes;
	}
	public void setIngredientes(Set<ComidaIngrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}
	/**
	 * @param idComida
	 * @param nombre
	 * @param precio
	 * @param url
	 * @param ingredientes
	 */
	public Comida(Integer idComida, String nombre, Double precio, String url, Set<ComidaIngrediente> ingredientes) {
		super();
		this.idComida = idComida;
		this.nombre = nombre;
		this.precio = precio;
		this.url = url;
		this.ingredientes = ingredientes;
	}
	
	/**
	 * 
	 */
	public Comida() {
		// TODO Auto-generated constructor stub
	}
}
