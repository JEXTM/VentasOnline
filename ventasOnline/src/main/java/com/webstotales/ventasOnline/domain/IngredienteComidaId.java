/**
 * Created By: JEXTM 5 set. 2016
 */
package com.webstotales.ventasOnline.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

/**
 * @author JEXTM
 *
 */
@Embeddable
public class IngredienteComidaId implements Serializable{
	/**
	 * Generate By: JEXTM 5 set. 2016
	 */
	@ManyToOne
	private Comida comida;
	@ManyToOne
	private Ingrediente ingrediente;
	public Comida getComida() {
		return comida;
	}
	public void setComida(Comida comida) {
		this.comida = comida;
	}
	public Ingrediente getIngrediente() {
		return ingrediente;
	}
	public void setIngrediente(Ingrediente ingrediente) {
		this.ingrediente = ingrediente;
	}
	/**
	 * @param comida
	 * @param ingrediente
	 */
	public IngredienteComidaId(Comida comida, Ingrediente ingrediente) {
		super();
		this.comida = comida;
		this.ingrediente = ingrediente;
	}
	
	/**
	 * 
	 */
	public IngredienteComidaId() {
		// TODO Auto-generated constructor stub
	}
}
