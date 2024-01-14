/**
 * 
 */
package com.mx.web.app.controller;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Base64;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.model.file.UploadedFile;

/**
 * @author Usuario 2
 *
 */

@Named
@SessionScoped
public class fileController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4009935993958059606L;

	private String nombreUsuario;

	private String signature;

	private UploadedFile firmaFile;

	/**
	 * @return the firmaFile
	 */
	public UploadedFile getFirmaFile() {
		return firmaFile;
	}

	public void guardarFirma() {
		// Obtenemos la firma como datos URL (base64) usando JavaScript
		String firmaDataURL = signature;

		// Examinamos y extraemos la parte de datos base64
		String[] partes = firmaDataURL.split(",");
		if (partes.length == 2) {
			String base64Data = partes[1];

			// Decodificamos la parte base64 a bytes
			byte[] firmaBytes = Base64.getDecoder().decode(base64Data);

			// Ahora puedes hacer lo que quieras con los bytes de la firma
			// En este ejemplo, simplemente mostramos un mensaje
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Firma guardada correctamente.", null);
			FacesContext.getCurrentInstance().addMessage(null, message);

			try {
//				firmaFile = new MyUploadedFile(base64Data);
			} catch (Exception e) {
				// TODO: handle exception
			}
		} else {
			// Manejar el error si no se puede extraer la parte base64
			FacesMessage errorMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al obtener la firma.",
					null);
			FacesContext.getCurrentInstance().addMessage(null, errorMessage);
		}
	}

	/**
	 * @return the nombreUsuario
	 */
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	/**
	 * @param nombreUsuario the nombreUsuario to set
	 */
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	/**
	 * @return the signature
	 */
	public String getSignature() {
		return signature;
	}

	/**
	 * @param signature the signature to set
	 */
	public void setSignature(String signature) {
		this.signature = signature;
	}

}
