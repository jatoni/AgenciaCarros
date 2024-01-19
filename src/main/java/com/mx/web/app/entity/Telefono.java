/**
 * 
 */
package com.mx.web.app.entity;

/**
 * @author Usuario 2
 *
 */
public class Telefono {
	private Long id;
	private String telefono;

	public Telefono() {

	}

	public Telefono(Long id, String telefono) {
		super();
		this.id = id;
		this.telefono = telefono;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}
