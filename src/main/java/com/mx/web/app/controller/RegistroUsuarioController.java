/**
 * 
 */
package com.mx.web.app.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 * @author Usuario 2
 *
 */

@Named
@SessionScoped
public class RegistroUsuarioController implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6186611598826373906L;
	private String nombre;
	private String apellido;
	private String apellidoMaterno;

	// Getters y Setters

	public void guardar() {
		// Lógica de guardado aquí
		System.out.println("Guardando: " + nombre + " " + apellido + " " + apellidoMaterno);
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
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * @param apellido the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
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

}
