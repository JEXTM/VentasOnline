/**
 * Created By: JEXTM 4 set. 2016
 */
package com.webstotales.ventasOnline.domain;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import java.util.Date;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.Email;


/**
 * @author JEXTM
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED) 
@Table(name="t_persona")
public class Persona {
	/**
	 * Generate By: JEXTM 4 set. 2016
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idUsuario;
	
	@Column(name="nombre",nullable=false)
	private String nombre;
	
	@Column(name="apellidoPaterno", nullable=false)
	private String apellidoPat;
	
	@Column(name="apellidoMaterno", nullable=false)
	private String apellidoMat;
	
	@Column(name="direccion",nullable=true )
	private String direccion;
	
	@Column(name="url", nullable=true)
	private String url;
	
	@Column(name="sexo", nullable=false)
	private Character sexo;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fechaNac", nullable=false)
	private Date fechaNac;
	
	@Column(name="celular", nullable=false)
	private String celular;
	
	@Email
	@Column(name="correo")
	private String correo;
	
	@Column(name="referencia")
	private String referencia;
	
	@ManyToOne
	@JoinColumn(name="idDistrito")
	private Distrito distrito;
	
	@Column(name="peso")
	private Double peso;
	
	@Column(name="talla")
	private Double talla;
	
	@Column(name="idmc")
	private Double idmc;
	
	
	@Column(name="dni")
	private Integer dni;
	
	
	@OneToOne
	@JoinColumn(name="idTarjeta")
	private Tarjeta tarjeta;
	/**
	 * 
	 */
	public Persona() {
		// TODO Auto-generated constructor stub
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Character getSexo() {
		return sexo;
	}

	public void setSexo(Character sexo) {
		this.sexo = sexo;
	}

	public Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public Distrito getDistrito() {
		return distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
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


	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	/**
	 * @param idUsuario
	 * @param nombre
	 * @param apellidoPat
	 * @param apellidoMat
	 * @param direccion
	 * @param url
	 * @param sexo
	 * @param fechaNac
	 * @param celular
	 * @param correo
	 * @param referencia
	 * @param distrito
	 * @param peso
	 * @param talla
	 * @param idmc
	 * @param dni
	 */
	public Persona(Integer idUsuario, String nombre, String apellidoPat, String apellidoMat, String direccion,
			String url, Character sexo, Date fechaNac, String celular, String correo, String referencia,
			Distrito distrito, Double peso, Double talla, Double idmc, Integer dni) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.apellidoPat = apellidoPat;
		this.apellidoMat = apellidoMat;
		this.direccion = direccion;
		this.url = url;
		this.sexo = sexo;
		this.fechaNac = fechaNac;
		this.celular = celular;
		this.correo = correo;
		this.referencia = referencia;
		this.distrito = distrito;
		this.peso = peso;
		this.talla = talla;
		this.idmc = idmc;
		this.dni = dni;
	}

	/**
	 * @param nombre
	 * @param apellidoPat
	 * @param apellidoMat
	 * @param direccion
	 * @param url
	 * @param sexo
	 * @param fechaNac
	 * @param celular
	 * @param correo
	 * @param referencia
	 * @param distrito
	 * @param peso
	 * @param talla
	 * @param idmc
	 * @param dni
	 */
	public Persona(String nombre, String apellidoPat, String apellidoMat, String direccion, String url, Character sexo,
			Date fechaNac, String celular, String correo, String referencia, Distrito distrito, Double peso,
			Double talla, Double idmc, Integer dni) {
		super();
		this.nombre = nombre;
		this.apellidoPat = apellidoPat;
		this.apellidoMat = apellidoMat;
		this.direccion = direccion;
		this.url = url;
		this.sexo = sexo;
		this.fechaNac = fechaNac;
		this.celular = celular;
		this.correo = correo;
		this.referencia = referencia;
		this.distrito = distrito;
		this.peso = peso;
		this.talla = talla;
		this.idmc = idmc;
		this.dni = dni;
	}

	/**
	 * @param idUsuario
	 * @param nombre
	 * @param apellidoPat
	 * @param apellidoMat
	 * @param direccion
	 * @param url
	 * @param sexo
	 * @param fechaNac
	 * @param celular
	 * @param correo
	 * @param referencia
	 * @param distrito
	 * @param peso
	 * @param talla
	 * @param idmc
	 * @param dni
	 * @param tarjeta
	 */
	public Persona(Integer idUsuario, String nombre, String apellidoPat, String apellidoMat, String direccion,
			String url, Character sexo, Date fechaNac, String celular, String correo, String referencia,
			Distrito distrito, Double peso, Double talla, Double idmc, Integer dni, Tarjeta tarjeta) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.apellidoPat = apellidoPat;
		this.apellidoMat = apellidoMat;
		this.direccion = direccion;
		this.url = url;
		this.sexo = sexo;
		this.fechaNac = fechaNac;
		this.celular = celular;
		this.correo = correo;
		this.referencia = referencia;
		this.distrito = distrito;
		this.peso = peso;
		this.talla = talla;
		this.idmc = idmc;
		this.dni = dni;
		this.tarjeta = tarjeta;
	}

	public Tarjeta getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}

	
	
	
	

}
