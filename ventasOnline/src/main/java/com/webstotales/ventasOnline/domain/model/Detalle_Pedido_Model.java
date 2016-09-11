/**
 * Created By: JEXTM 10 set. 2016
 */
package com.webstotales.ventasOnline.domain.model;

import java.util.Date;

/**
 * @author JEXTM
 *
 */

public class Detalle_Pedido_Model {
	/**
	 * Generate By: JEXTM 10 set. 2016
	 */
	private Integer idPedido;
	private String nombre;
	private String apellido;
	private String dirrecion;
	private Date fecha;
	private Character estado;
	private String comida;
	private Long cantidad;
	private Double precio;
	private Double importe;
	public Integer getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDirrecion() {
		return dirrecion;
	}
	public void setDirrecion(String dirrecion) {
		this.dirrecion = dirrecion;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Character getEstado() {
		return estado;
	}
	public void setEstado(Character estado) {
		this.estado = estado;
	}
	public String getComida() {
		return comida;
	}
	public void setComida(String comida) {
		this.comida = comida;
	}
	public Long getCantidad() {
		return cantidad;
	}
	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public Double getImporte() {
		return importe;
	}
	public void setImporte(Double importe) {
		this.importe = importe;
	}
	/**
	 * @param idPedido
	 * @param nombre
	 * @param apellido
	 * @param dirrecion
	 * @param fecha
	 * @param estado
	 * @param comida
	 * @param cantidad
	 * @param precio
	 * @param importe
	 */
	public Detalle_Pedido_Model(Integer idPedido, String nombre, String apellido, String dirrecion, Date fecha,
			Character estado, String comida, Long cantidad, Double precio, Double importe) {
		super();
		this.idPedido = idPedido;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dirrecion = dirrecion;
		this.fecha = fecha;
		this.estado = estado;
		this.comida = comida;
		this.cantidad = cantidad;
		this.precio = precio;
		this.importe = importe;
	}
	
	/**
	 * 
	 */
	public Detalle_Pedido_Model() {

	}
	
	
	
	
}
