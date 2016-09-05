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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author JEXTM
 *
 */
@Entity
@Table(name="t_ingrediente")
public class Ingrediente {
	/**
	 * Generate By: JEXTM 5 set. 2016
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idIngrediente;
	@Column(name="nombre", nullable=false)
	private String nombre;
	@Column(name="cantidad")
	private Integer cantidad;
	@Column(name="unidad")
	private String unidad;
	@OneToMany(fetch=FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "pk.ingrediente")
	private Set<ComidaIngrediente> comida = new HashSet<ComidaIngrediente>(0);
	public Integer getIdIngrediente() {
		return idIngrediente;
	}
	public void setIdIngrediente(Integer idIngrediente) {
		this.idIngrediente = idIngrediente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public String getUnidad() {
		return unidad;
	}
	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}
	
	/**
	 * @param idIngrediente
	 * @param nombre
	 * @param cantidad
	 * @param unidad
	 * @param comida
	 */
	public Ingrediente(Integer idIngrediente, String nombre, Integer cantidad, String unidad, Set<ComidaIngrediente> comida) {
		super();
		this.idIngrediente = idIngrediente;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.unidad = unidad;
		this.comida = comida;
	}
	public Set<ComidaIngrediente> getComida() {
		return comida;
	}
	public void setComida(Set<ComidaIngrediente> comida) {
		this.comida = comida;
	}
	/**
	 * @param idIngrediente
	 * @param nombre
	 * @param cantidad
	 * @param unidad
	 */
	public Ingrediente(Integer idIngrediente, String nombre, Integer cantidad, String unidad) {
		super();
		this.idIngrediente = idIngrediente;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.unidad = unidad;
	}
	/**
	 * 
	 */
	public Ingrediente() {
		// TODO Auto-generated constructor stub
	}
}
