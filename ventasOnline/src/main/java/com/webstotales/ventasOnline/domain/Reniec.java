/**
 * Created By: JEXTM 26 set. 2016
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
@Table(name="t_reniec")
public class Reniec {
	/**
	 * Generate By: JEXTM 26 set. 2016
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idReniec;
	@Column(name="nombre")
	private String nombre;
	@Column(name="apellidoPat")
	private String apellidoPat;
	@Column(name="apellidoMat")
	private String apellidoMat;
	@Column(name="fechaNac")
	private Date fechaNac;
	@Column(name="direccion")
	private String direccion;
	@ManyToOne
	@JoinColumn(name="idDistrito", nullable=false)
	private Distrito distrito;
	public Integer getIdReniec() {
		return idReniec;
	}
	public void setIdReniec(Integer idReniec) {
		this.idReniec = idReniec;
	}
	public String getApellidoPat() {
		return apellidoPat;
	}
	public void setApellidoPat(String apellidoPat) {
		this.apellidoPat = apellidoPat;
	}
	public String getApellidoMat() {
		return apellidoMat;
	}
	public void setApellidoMat(String apellidoMat) {
		this.apellidoMat = apellidoMat;
	}
	public Date getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Distrito getDistrito() {
		return distrito;
	}
	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @param idReniec
	 * @param nombre
	 * @param apellidoPat
	 * @param apellidoMat
	 * @param fechaNac
	 * @param direccion
	 * @param distrito
	 */
	public Reniec(Integer idReniec, String nombre, String apellidoPat, String apellidoMat, Date fechaNac,
			String direccion, Distrito distrito) {
		super();
		this.idReniec = idReniec;
		this.nombre = nombre;
		this.apellidoPat = apellidoPat;
		this.apellidoMat = apellidoMat;
		this.fechaNac = fechaNac;
		this.direccion = direccion;
		this.distrito = distrito;
	}
	
	
	
	
}
