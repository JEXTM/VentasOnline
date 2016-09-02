/**
 * Created By: JEXTM 2 set. 2016
 */
package com.webstotales.ventasOnline.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author JEXTM
 *
 */
@Entity
@Table(name="t_test")
public class Test {
	/**
	 * Generate By: JEXTM 2 set. 2016
	 */
	@Id
	private int id;
	@Column(name="name",nullable=false)
	private String name;
	@Column(name="apellido",nullable=false)
	private String apellido;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	/**
	 * @param id
	 * @param name
	 * @param apellido
	 */
	public Test(int id, String name, String apellido) {
		super();
		this.id = id;
		this.name = name;
		this.apellido = apellido;
	}
	
	/**
	 * 
	 */
	public Test() {
		// TODO Auto-generated constructor stub
	}
}
