/**
 * 
 */
package com.mx.web.app.entity;

/**
 * @author Usuario 2
 *
 */
public class Correo {
	private Long id;
	private String correo;

	public Correo() {

	}

	public Correo(Long id, String correo) {
		this.id = id;
		this.correo = correo;
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
	 * @return the correo
	 */
	public String getCorreo() {
		return correo;
	}

	/**
	 * @param correo the correo to set
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}

}
