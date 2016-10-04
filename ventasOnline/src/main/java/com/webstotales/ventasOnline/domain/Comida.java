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
@Table(name="t_presentacion")
public class Comida {
	/**
	 * Generate By: JEXTM 5 set. 2016
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idComida;
	
	@Column(name="nombre",nullable=false)
	private String nombre;
	
	@Column(name="precio")
	private Double precio;
	
	@Column(name="cantidad")
	private Integer cantidad;
	
	@Column(name="estado")
	private Character estado;
	
	@Column(name="url")
	private String url;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy = "pk.comida")
	private Set<ComidaIngrediente> ingredientes = new HashSet<ComidaIngrediente>(0);

	public Integer getIdPresentacion() {
		return idComida;
	}

	public void setIdPresentacion(Integer idPresentacion) {
		this.idComida = idPresentacion;
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

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
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

	public Character getEstado() {
		return estado;
	}

	public void setEstado(Character estado) {
		this.estado = estado;
	}

	/**
	 * @param idPresentacion
	 * @param nombre
	 * @param precio
	 * @param cantidad
	 * @param estado
	 * @param url
	 * @param ingredientes
	 */
	public Comida(Integer idComida, String nombre, Double precio, Integer cantidad, Character estado, String url,
			Set<ComidaIngrediente> ingredientes) {
		super();
		this.idComida = idComida;
		this.nombre = nombre;
		this.precio = precio;
		this.cantidad = cantidad;
		this.estado = estado;
		this.url = url;
		this.ingredientes = ingredientes;
	}

	/**
	 * @param nombre
	 * @param precio
	 * @param cantidad
	 * @param estado
	 * @param url
	 * @param ingredientes
	 */
	public Comida(String nombre, Double precio, Integer cantidad, Character estado, String url,
			Set<ComidaIngrediente> ingredientes) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.cantidad = cantidad;
		this.estado = estado;
		this.url = url;
		this.ingredientes = ingredientes;
	}

	/**
	 * @param nombre
	 * @param precio
	 * @param cantidad
	 * @param estado
	 * @param url
	 */
	public Comida(String nombre, Double precio, Integer cantidad, Character estado, String url) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.cantidad = cantidad;
		this.estado = estado;
		this.url = url;
	}

	/**
	 * 
	 */
	public Comida() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
