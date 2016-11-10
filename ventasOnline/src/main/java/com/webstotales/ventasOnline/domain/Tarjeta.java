/**
 * Created By: JEXTM 27 oct. 2016
 */
package com.webstotales.ventasOnline.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author JEXTM
 *
 */
@Entity
@Table(name="t_tarjeta")
public class Tarjeta {
	/**
	 * Generate By: JEXTM 27 oct. 2016
	 */
	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	private Integer idTarjeta;
	
	@Column(name="saldo")
	private Double saldo;
	
	@Column(name="numero")
	private String numero;

	public Integer getIdTarjeta() {
		return idTarjeta;
	}

	public void setIdTarjeta(Integer idTarjeta) {
		this.idTarjeta = idTarjeta;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	/**
	 * @param idTarjeta
	 * @param saldo
	 * @param numero
	 * @param usuario
	 */
	public Tarjeta(Integer idTarjeta, Double saldo, String numero) {
		super();
		this.idTarjeta = idTarjeta;
		this.saldo = saldo;
		this.numero = numero;
	}
	/**
	 * 
	 */
	public Tarjeta() {
		// TODO Auto-generated constructor stub
	}	
	
	

}