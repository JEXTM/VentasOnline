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
	/**
	 * @param idUsuario
	 * @param username
	 * @param password
	 * @param estado
	 * @param nombre
	 * @param apellido
	 * @param direccion
	 * @param dni
	 * @param email
	 */
	public Cliente(Integer idUsuario, String username, String password, Character estado, String nombre,
			String apellido, String direccion, Integer dni, String email) {
		super(idUsuario, username, password, estado, nombre, apellido, direccion);
		this.dni = dni;
		this.email = email;
	}
	
	/**
	 * 
	 */
	public Cliente() {
		// TODO Auto-generated constructor stub
	}
}
