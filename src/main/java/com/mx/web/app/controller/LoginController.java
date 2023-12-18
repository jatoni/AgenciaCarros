/**
 * 
 */
package com.mx.web.app.controller;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.inject.Named;

import com.mx.web.app.dao.TbEmployeeDao;
import com.mx.web.app.utils.CommonUtils;

import java.io.IOException;
import java.io.Serializable;

/**
 * @author jat_a
 * 
 * 
 *         Clase que ayuda al controlador del logeo
 */
@Named("loginController")
@SessionScoped
public class LoginController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7986869361800919069L;

	@Inject
	private TbEmployeeDao tbEmployeeDaoImpl;

	/*
	 * usuario que ingresa el usuario
	 */
	private String username;

	/*
	 * password que ingresa el usuario
	 */
	private String password;

	/**
	 * Metodo que ayuda a hacer el login de la aplicacion
	 */
	public void login() {
		if (tbEmployeeDaoImpl.login(this.username, this.password)) {
			try {
				CommonUtils.redireccionar("/app/Home.xhtml");
			} catch (IOException e) {
				e.printStackTrace();
				CommonUtils.showMessage(FacesMessage.SEVERITY_FATAL, "Error!!",
						"Formato incorrecto en el cual se ingresa a la pantalla deseada");
			}
		} else {
			CommonUtils.showMessage(FacesMessage.SEVERITY_ERROR, "Ups!!", "El usuario y/o contraseña son incorrectos");
		}
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
