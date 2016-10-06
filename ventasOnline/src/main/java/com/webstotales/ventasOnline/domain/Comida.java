/**
 * Created By: JEXTM 5 set. 2016
 */
package com.webstotales.ventasOnline.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
	
	@ManyToOne
	@JoinColumn(name="idTipo")
	private TipoComida tipoComida;


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


	public Integer getCantidad() {
		return cantidad;
	}


	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}


	public Character getEstado() {
		return estado;
	}


	public void setEstado(Character estado) {
		this.estado = estado;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public TipoComida getTipoComida() {
		return tipoComida;
	}


	public void setTipoComida(TipoComida tipoComida) {
		this.tipoComida = tipoComida;
	}


	public Comida(String nombre, Double precio, Integer cantidad, Character estado, String url, TipoComida tipoComida) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.cantidad = cantidad;
		this.estado = estado;
		this.url = url;
		this.tipoComida = tipoComida;
	}
	
	public Comida() {
		// TODO Auto-generated constructor stub
	}
	
}
