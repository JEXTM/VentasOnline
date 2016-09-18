/**
 * Created By: JEXTM 4 set. 2016
 */
package com.webstotales.ventasOnline.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import static javax.persistence.InheritanceType.JOINED;
import javax.persistence.Table;

/**
 * @author JEXTM
 *
 */
@Entity
@Table(name="t_usuario")
@Inheritance(strategy= JOINED)
@DiscriminatorColumn(name = "role")
public class Users {
	/**
	 * Generate By: JEXTM 4 set. 2016
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idUsuario;
	@Column(name="username", nullable=false, unique=true)
	private String username;
	@Column(name="password", nullable=false)
	private String password;
	@Column(name="estado", nullable=false)
	private Character estado;
	@Column(name="role")
	private Character role;
	@Column(name="nombre",nullable=false)
	private String nombre;
	@Column(name="apellido", nullable=false)
	private String apellido;
	@Column(name="direccion",nullable=true )
	private String direccion;
	@Column(name="url", nullable=true)
	private String url;
	@Column(name="sexo", nullable=false)
	private Character sexo;
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Character getEstado() {
		return estado;
	}
	public void setEstado(Character estado) {
		this.estado = estado;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
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
	public Character getRole() {
		return role;
	}
	public void setRole(Character role) {
		this.role = role;
	}
	public Character getSexo() {
		return sexo;
	}
	public void setSexo(Character sexo) {
		this.sexo = sexo;
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
	 */
	public Users(Integer idUsuario, String username, String password, Character estado, Character role, String nombre,
			String apellido, String direccion, String url, Character sexo) {
		super();
		this.idUsuario = idUsuario;
		this.username = username;
		this.password = password;
		this.estado = estado;
		this.role = role;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.url = url;
		this.sexo = sexo;
	}
	public Users() {
		// TODO Auto-generated constructor stub
	}

}
