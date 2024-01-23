package com.mx.web.app.entity;

import java.io.Serializable;
import java.util.List;

public class Usuario implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6145856343265805022L;
	private Long id;
	private String usuario;
	private String sargento;
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private List<Correo> correos;
	private List<Telefono> telefonos;

	public Usuario() {

	}

	public Usuario(Long id, String usuario, String sargento, String nombre, String apellidoPaterno,
			String apellidoMaterno, List<Correo> correos, List<Telefono> telefonos) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.sargento = sargento;
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.correos = correos;
		this.telefonos = telefonos;
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
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the sargento
	 */
	public String getSargento() {
		return sargento;
	}

	/**
	 * @param sargento the sargento to set
	 */
	public void setSargento(String sargento) {
		this.sargento = sargento;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellidoPaterno
	 */
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	/**
	 * @param apellidoPaterno the apellidoPaterno to set
	 */
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	/**
	 * @return the apellidoMaterno
	 */
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	/**
	 * @param apellidoMaterno the apellidoMaterno to set
	 */
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	/**
	 * @return the correos
	 */
	public List<Correo> getCorreos() {
		return correos;
	}

	/**
	 * @param correos the correos to set
	 */
	public void setCorreos(List<Correo> correos) {
		this.correos = correos;
	}

	/**
	 * @return the telefonos
	 */
	public List<Telefono> getTelefonos() {
		return telefonos;
	}

	/**
	 * @param telefonos the telefonos to set
	 */
	public void setTelefonos(List<Telefono> telefonos) {
		this.telefonos = telefonos;
	}

}
