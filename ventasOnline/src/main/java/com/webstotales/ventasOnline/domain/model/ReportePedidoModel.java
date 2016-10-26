package com.webstotales.ventasOnline.domain.model;

import com.webstotales.ventasOnline.domain.Usuario;

public class ReportePedidoModel {
	private Usuario usuario;
	private Long cantidad;
	public ReportePedidoModel(Usuario usuario, Long cantidad) {
		super();
		this.usuario = usuario;
		this.cantidad = cantidad;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Long getCantidad() {
		return cantidad;
	}
	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}
	
	
	public ReportePedidoModel() {
		// TODO Auto-generated constructor stub
	}
}
