/**
 * Created By: JEXTM 4 set. 2016
 */
package com.webstotales.ventasOnline.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;

/**
 * @author JEXTM
 *
 */
@Entity
@DiscriminatorValue("C")
@Table(name="t_cliente")
public class Cliente extends Users{
	/**
	 * Generate By: JEXTM 4 set. 2016
	 */
	@Column(name="dni")
	private Integer dni;
	@Email
	@Column(name="email")
	private String email;
	@Column(name="ocupacion")
	private String ocupacion;
	@Column(name="peso")
	private Double peso;
	@Column(name="talla")
	private Double talla;
	@Column(name="idmc")
	private Double idmc;
	
	public Integer getDni() {
		return dni;
	}
	public void setDni(Integer dni) {
		this.dni = dni;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOcupacion() {
		return ocupacion;
	}
	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}
	public Double getPeso() {
		return peso;
	}
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	public Double getTalla() {
		return talla;
	}
	public void setTalla(Double talla) {
		this.talla = talla;
	}
	public Double getIdmc() {
		return idmc;
	}
	public void setIdmc(Double idmc) {
		this.idmc = idmc;
	}
	/**
	 * @param idUsuario
	 * @param username
	 * @param password
	 * @param estado
	 * @param role
	 * @param nombre
	 * @param apellido
	 * @param direccion
	 * @param url
	 * @param sexo
	 * @param dni
	 * @param email
	 * @param ocupacion
	 * @param peso
	 * @param talla
	 * @param idmc
	 */
	public Cliente(Integer idUsuario, String username, String password, Character estado, Character role, String nombre,
			String apellido, String direccion, String url, Character sexo, Integer dni, String email, String ocupacion,
			Double peso, Double talla, Double idmc) {
		super(idUsuario, username, password, estado, role, nombre, apellido, direccion, url, sexo);
		this.dni = dni;
		this.email = email;
		this.ocupacion = ocupacion;
		this.peso = peso;
		this.talla = talla;
		this.idmc = idmc;
	}
	public Cliente(){
		
	}
	
}
