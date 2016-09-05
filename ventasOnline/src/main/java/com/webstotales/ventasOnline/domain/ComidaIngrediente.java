/**
 * Created By: JEXTM 5 set. 2016
 */
package com.webstotales.ventasOnline.domain;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

/**
 * @author JEXTM
 *
 */
@Entity
@Table(name="t_comida_ingrediente")
@AssociationOverrides({
	@AssociationOverride(name = "pk.comida",
		joinColumns = @JoinColumn(name = "idComida")),
	@AssociationOverride(name = "pk.ingrediente",
		joinColumns = @JoinColumn(name = "idIngrediente")) })
public class ComidaIngrediente {
	/**
	 * Generate By: JEXTM 5 set. 2016
	 */
	@EmbeddedId
	private IngredienteComidaId pk = new IngredienteComidaId();
	@Column(name="cantidadUsada")
	private Integer cantidadUsada;
	@Column(name="unidad")
	private String unidad;
	public IngredienteComidaId getPk() {
		return pk;
	}
	public void setPk(IngredienteComidaId pk) {
		this.pk = pk;
	}
	public Integer getCantidadUsada() {
		return cantidadUsada;
	}
	public void setCantidadUsada(Integer cantidadUsada) {
		this.cantidadUsada = cantidadUsada;
	}
	public String getUnidad() {
		return unidad;
	}
	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}
	/**
	 * @param pk
	 * @param cantidadUsada
	 * @param unidad
	 */
	public ComidaIngrediente(IngredienteComidaId pk, Integer cantidadUsada, String unidad) {
		super();
		this.pk = pk;
		this.cantidadUsada = cantidadUsada;
		this.unidad = unidad;
	}
	/**
	 * 
	 */
	public ComidaIngrediente() {
		// TODO Auto-generated constructor stub
	}
	
}
