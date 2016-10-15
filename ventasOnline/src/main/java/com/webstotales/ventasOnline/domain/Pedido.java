/**
 * Created By: JEXTM 4 set. 2016
 */
package com.webstotales.ventasOnline.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import static javax.persistence.TemporalType.TIMESTAMP;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author JEXTM
 *
 */
@Entity
@Table(name="t_pedido")
public class Pedido implements Serializable{
	/**
	 * Generate By: JEXTM 4 set. 2016
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idPedido;
	@ManyToOne
	@JoinColumn(name="idUsuario")
	private Usuario usuario;
	@Column(name="importe",nullable=false)
	private Double importe;
	@ManyToOne
	@JoinColumn(name="idEstado")
	private EstadoPedido estado;
	@Past
	@NotNull
	@DateTimeFormat(pattern = "dd/MM/YYYY")
	@Temporal(TIMESTAMP)
	private Date fecha;
	
	@Column(name="tipo_comprobante")
	private Character tipo_comprobante;

	public Integer getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Double getImporte() {
		return importe;
	}

	public void setImporte(Double importe) {
		this.importe = importe;
	}

	public EstadoPedido getEstado() {
		return estado;
	}

	public void setEstado(EstadoPedido estado) {
		this.estado = estado;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Character getTipo_comprobante() {
		return tipo_comprobante;
	}

	public void setTipo_comprobante(Character tipo_comprobante) {
		this.tipo_comprobante = tipo_comprobante;
	}

	/**
	 * @param idPedido
	 * @param usuario
	 * @param importe
	 * @param estado
	 * @param fecha
	 * @param tipo_comprobante
	 */
	public Pedido(Integer idPedido, Usuario usuario, Double importe, EstadoPedido estado, Date fecha,
			Character tipo_comprobante) {
		super();
		this.idPedido = idPedido;
		this.usuario = usuario;
		this.importe = importe;
		this.estado = estado;
		this.fecha = fecha;
		this.tipo_comprobante = tipo_comprobante;
	}

	/**
	 * @param usuario
	 * @param importe
	 * @param estado
	 * @param fecha
	 * @param tipo_comprobante
	 */
	public Pedido(Usuario usuario, Double importe, EstadoPedido estado, Date fecha, Character tipo_comprobante) {
		super();
		this.usuario = usuario;
		this.importe = importe;
		this.estado = estado;
		this.fecha = fecha;
		this.tipo_comprobante = tipo_comprobante;
	}
	
	/**
	 * 
	 */
	public Pedido() {
		// TODO Auto-generated constructor stub
	}
	
	
}
