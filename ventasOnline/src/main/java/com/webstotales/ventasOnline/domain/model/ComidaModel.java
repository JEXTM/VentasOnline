package com.webstotales.ventasOnline.domain.model;

import com.webstotales.ventasOnline.domain.Comida;

public class ComidaModel {
	
	private Integer idCarrito;
	
	private Comida comida;

	public ComidaModel(Integer idCarrito, Comida comida) {
		super();
		this.idCarrito = idCarrito;
		this.comida = comida;
	}

	public ComidaModel() {
		// TODO Auto-generated constructor stub
	}

	public Integer getIdCarrito() {
		return idCarrito;
	}

	public void setIdCarrito(Integer idCarrito) {
		this.idCarrito = idCarrito;
	}

	public Comida getComida() {
		return comida;
	}

	public void setComida(Comida comida) {
		this.comida = comida;
	}
	
}
