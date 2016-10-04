/**
 * Created By: JEXTM 1 oct. 2016
 */
package com.webstotales.ventasOnline.domain;

import java.util.Date;

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
@Table(name="t_boleta")
public class Boleta {
	/**
	 * Generate By: JEXTM 1 oct. 2016
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name="fecha_emision")
	private Date fecha_emision;
	@ManyToOne
	@JoinColumn(name="idPedido")
	private Pedido pedido;
	
	/**
	 * 
	 */
	public Boleta() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFecha_emision() {
		return fecha_emision;
	}

	public void setFecha_emision(Date fecha_emision) {
		this.fecha_emision = fecha_emision;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	/**
	 * @param id
	 * @param fecha_emision
	 * @param pedido
	 */
	public Boleta(Integer id, Date fecha_emision, Pedido pedido) {
		super();
		this.id = id;
		this.fecha_emision = fecha_emision;
		this.pedido = pedido;
	}
	
	
}
