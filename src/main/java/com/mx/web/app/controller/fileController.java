/**
 * 
 */
package com.mx.web.app.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.imageio.ImageIO;
import javax.inject.Named;

import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.mx.web.app.utils.CommonUtils;

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

	private String signature;

	private String nombreUsuario;

	private static final int imageType = XWPFDocument.PICTURE_TYPE_PNG;

	private int width = 500;
	private int height = 500;

	public void procesarImagen() {
		String ruta = "C:\\Users\\Usuario 2\\Documents\\imagen.jpg";

		if (generarImagenconCodigoQR(signature, ruta)) {
			CommonUtils.showMessage(FacesMessage.SEVERITY_INFO, "Exito", "Se guardo con exito la imagen");
		} else {
			CommonUtils.showMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error al guardar la imagen");
		}
	}

	public boolean generarImagenconCodigoQR(String data, String rutaImagen) {
		Map<EncodeHintType, Object> hintMap = new HashMap<>();
		hintMap.put(EncodeHintType.CHARACTER_SET, "UTF-8");
		try {
			// Crear el código QR
			BitMatrix bitMatrix = new QRCodeWriter().encode(data, BarcodeFormat.QR_CODE, width, height, hintMap);

			// Guardar la imagen en el archivo
			MatrixToImageWriter.writeToPath(bitMatrix, "PNG", new File(rutaImagen).toPath());
			return true;
		} catch (WriterException | IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public byte[] comprimirFirma(String firma) {
		try  {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public void guardarImage() {
		FileOutputStream fout = null;
		XWPFDocument document = null;
		try {
			byte[] firmaBytes = signature.getBytes();

			InputStream inputStream = new ByteArrayInputStream(firmaBytes);
			BufferedImage imagen = ImageIO.read(inputStream);
			File archivoImagen = new File("C:\\Users\\Usuario 2\\Documents\\imagen.jpg");
			ImageIO.write(imagen, "jpg", archivoImagen);

			document = new XWPFDocument();

			XWPFParagraph paragraph = document.createParagraph();

			XWPFRun run = paragraph.createRun();

			fout = new FileOutputStream(new File("C:\\Users\\Usuario 2\\Documents\\wordFile.docx"));

			run.addPicture(inputStream, imageType, "Firma Digital", Units.toEMU(width), Units.toEMU(height));
			document.write(fout);

		} catch (Exception e) {
			CommonUtils.showMessage(FacesMessage.SEVERITY_ERROR, "Error al guardar al empleado", "");
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			try {
				if (fout != null) {
					fout.close();
				}
				if (document != null) {
					document.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

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

}
