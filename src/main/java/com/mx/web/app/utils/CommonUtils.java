/**
 * 
 */
package com.mx.web.app.utils;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 * @author jat_a
 * 
 *         Clase para crear funciones globales o constantes globales.
 */
public class CommonUtils {
	/**
	 * @param severity
	 * @param summary
	 * @param detail
	 */
	public static void showMessage(Severity severity, String summary, String detail) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, summary, detail));
	}

	/**
	 * Metodo que me permite redireccionar entre pantallas del aplicativo
	 * 
	 * @param url {@link String} direccion o pantalla a cambiar
	 * @throws IOException {@link IOException} excepcion en caso de error al
	 *                     encontrar la pagina
	 */
	public static void redireccionar(String url) throws IOException {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		String contextPath = externalContext.getRequestContextPath();
		externalContext.redirect(contextPath + url);
	}
}