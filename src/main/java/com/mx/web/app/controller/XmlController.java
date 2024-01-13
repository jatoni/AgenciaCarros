/**
 * 
 */
package com.mx.web.app.controller;

import java.io.Serializable;

import java.io.ByteArrayInputStream;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * 
 */

@Named
@SessionScoped
public class XmlController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3243854478181828126L;

	private String xmlContent;

	private StringBuilder builder;

	private UploadedFile uploadedFile;

	public void recursivoFile(NodeList nodos, int contador) {
		if (nodos.getLength() < 0 || nodos == null) {
			return;
		}
		Node hijo = nodos.item(contador);
		if (hijo.hasChildNodes()) {
			recursivoFile(hijo.getChildNodes(), contador++);
		} else {
			if (hijo.getNodeType() == Node.ELEMENT_NODE) {
				System.out.println(this.builder.append("Hijo: ").append(hijo.getNodeName()).append(", Valor: ")
						.append(hijo.getTextContent()));
				return;
			}
		}
	}

	public void handleFileUpload(FileUploadEvent event) {
		try {
			UploadedFile archivoCargado = event.getFile();
			byte[] xmlBytes = archivoCargado.getContent();
			ByteArrayInputStream entrada = new ByteArrayInputStream(xmlBytes);
			DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
			DocumentBuilder constructor = fabrica.newDocumentBuilder();
			Document documento = constructor.parse(entrada);
			Node raiz = documento.getDocumentElement();
			recursivoFile(raiz.getChildNodes(), 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	public void handleFileUpload(FileUploadEvent event) {
//		try {
//			UploadedFile archivoCargado = event.getFile();
//			byte[] xmlBytes = archivoCargado.getContent();
//			ByteArrayInputStream entrada = new ByteArrayInputStream(xmlBytes);
//			DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
//			DocumentBuilder constructor = fabrica.newDocumentBuilder();
//			Document documento = constructor.parse(entrada);
//			Node raiz = documento.getDocumentElement();
//
//			// apartir de aqui es meter la recursividad.
//
//			NodeList hijosDeRaiz = raiz.getChildNodes();
//			for (int i = 0; i < hijosDeRaiz.getLength(); i++) {
//				Node hijo = hijosDeRaiz.item(i);
//				if (hijo.getNodeType() == Node.ELEMENT_NODE) {
//					this.builder = new StringBuilder();
//					System.out.println(this.builder.append("Hijo: ").append(hijo.getNodeName()).append(", Valor: ")
//							.append(hijo.getTextContent()));
//
//					NodeList nietos = hijo.getChildNodes();
//					for (int j = 0; j < nietos.getLength(); j++) {
//						Node nieto = nietos.item(j);
//						if (nieto.getNodeType() == Node.ELEMENT_NODE) {
//							this.builder = new StringBuilder();
//							System.out.println(this.builder.append("Nieto: ").append(nieto.getNodeName())
//									.append(", Valor: ").append(nieto.getTextContent()));
//
//							NodeList bisnietos = nieto.getChildNodes();
//							for (int k = 0; k < bisnietos.getLength(); k++) {
//								Node bisnieto = bisnietos.item(k);
//								if (bisnieto.getNodeType() == Node.ELEMENT_NODE) {
//									this.builder = new StringBuilder();
//									System.out.println(this.builder.append("Bisnieto: ").append(bisnieto.getNodeName())
//											.append(", Valor: ").append(bisnieto.getTextContent()));
//								}
//							}
//						}
//					}
//				}
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * @return the xmlContent
	 */
	public String getXmlContent() {
		return xmlContent;
	}

	/**
	 * @param xmlContent the xmlContent to set
	 */
	public void setXmlContent(String xmlContent) {
		this.xmlContent = xmlContent;
	}

	/**
	 * @return the builder
	 */
	public StringBuilder getBuilder() {
		return builder;
	}

	/**
	 * @param builder the builder to set
	 */
	public void setBuilder(StringBuilder builder) {
		this.builder = builder;
	}

	/**
	 * @return the uploadedFile
	 */
	public UploadedFile getUploadedFile() {
		return uploadedFile;
	}

	/**
	 * @param uploadedFile the uploadedFile to set
	 */
	public void setUploadedFile(UploadedFile uploadedFile) {
		this.uploadedFile = uploadedFile;
	}

}
