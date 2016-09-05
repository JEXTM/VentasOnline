/**
 * Created By: JEXTM 4 set. 2016
 */
package com.webstotales.ventasOnline.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import static javax.persistence.TemporalType.DATE;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author JEXTM
 *
 */
@Entity
@Table(name="t_pedido")
public class Pedido {
	/**
	 * Generate By: JEXTM 4 set. 2016
	 */
	@Id
	private Integer idPedido;
	@ManyToOne
	@JoinColumn(name="idCliente", nullable=false)
	private Cliente idCliente;
	@Column(name="importe",nullable=false)
	private Double importe;
	@Column(name="estado",nullable=false)
	private Character estado;
	@Past
	@NotNull
	@DateTimeFormat(pattern = "dd/MM/YYYY")
	@Temporal(DATE)
	private Date fecha;
	public Integer getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}
	public Cliente getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Cliente idCliente) {
		this.idCliente = idCliente;
	}
	public Double getImporte() {
		return importe;
	}
	public void setImporte(Double importe) {
		this.importe = importe;
	}
	public Character getEstado() {
		return estado;
	}
	public void setEstado(Character estado) {
		this.estado = estado;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	/**
	 * @param idPedido
	 * @param idCliente
	 * @param importe
	 * @param estado
	 * @param fecha
	 */
	public Pedido(Integer idPedido, Cliente idCliente, Double importe, Character estado, Date fecha) {
		super();
		this.idPedido = idPedido;
		this.idCliente = idCliente;
		this.importe = importe;
		this.estado = estado;
		this.fecha = fecha;
	}
	
	
	/**
	 * 
	 */
	public Pedido() {
		// TODO Auto-generated constructor stub
	}
}
