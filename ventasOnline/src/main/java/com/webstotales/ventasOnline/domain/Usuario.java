/**
 * Created By: JEXTM 4 set. 2016
 */
package com.webstotales.ventasOnline.domain;

import java.util.Date;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * @author JEXTM
 *
 */
@Entity
@Table(name="t_usuario")
@PrimaryKeyJoinColumn(name="idUsuario")
public class Usuario extends Persona{
	/**
	 * Generate By: JEXTM 4 set. 2016
	 */
	@Column(name="Usuario")
	private String usuario;
	
	@Column(name="contrasena")
	private String contrasena;
	
	@Column(name="estado")
	private Character estado;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idRol")
	private Rol rol;
	
	
	
	/**
	 * 
	 */
	public Usuario() {
		// TODO Auto-generated constructor stub
	}



	public String getUsuario() {
		return usuario;
	}



	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}



	public String getContrasena() {
		return contrasena;
	}



	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}



	public Character getEstado() {
		return estado;
	}



	public void setEstado(Character estado) {
		this.estado = estado;
	}



	public Rol getRol() {
		return rol;
	}



	public void setRol(Rol rol) {
		this.rol = rol;
	}



	/**
	 * @param usuario
	 * @param contrasena
	 * @param estado
	 * @param rol
	 */
	public Usuario(String usuario, String contrasena, Character estado, Rol rol) {
		super();
		this.usuario = usuario;
		this.contrasena = contrasena;
		this.estado = estado;
		this.rol = rol;
	}



	public Usuario(String nombre, String apellidoPat, String apellidoMat, String direccion,
			String url, Character sexo, Date fechaNac, String celular, String correo, String referencia,
			Distrito distrito, Double peso, Double talla, Double idmc, Integer dni, String usuario, String contrasena,
			Character estado, Rol rol) {
		super( nombre, apellidoPat, apellidoMat, direccion, url, sexo, fechaNac, celular, correo, referencia,
				distrito, peso, talla, idmc, dni);
		this.usuario = usuario;
		this.contrasena = contrasena;
		this.estado = estado;
		this.rol = rol;
	}

	
	
}
