/**
 * 
 */
package com.mx.web.app.controller;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.inject.Named;

import com.mx.web.app.dao.TbCustomerDao;
import com.mx.web.app.dto.CustomerDto;
import com.mx.web.app.utils.CommonUtils;

/**
 * @author jat_a
 * 
 *         Controlador para el manejo de guardar clientes en vistas
 */

@Named
@SessionScoped
public class RegistroCustomerController implements Serializable {

	private static final long serialVersionUID = -9180958871052015855L;

	@Inject
	private CustomerDto customerDto;

	@Inject
	private TbCustomerDao cusTbCustomerDaoImpl;

	/**
	 * Controlador que manda a llamar a la impl para guardar a un cliente
	 */
	public void insertCustomer() {
		if (this.cusTbCustomerDaoImpl.inserCustomer(customerDto)) {
			CommonUtils.showMessage(FacesMessage.SEVERITY_INFO, "Exito", "Se guardo con exito el cliente");
			this.customerDto = null;
		} else {
			CommonUtils.showMessage(FacesMessage.SEVERITY_ERROR, "Ups!!", "El usuario no se pudo guardar");
		}
	}

	/**
	 * @return the customerDto
	 */
	public CustomerDto getCustomerDto() {
		return customerDto;
	}

	/**
	 * @param customerDto the customerDto to set
	 */
	public void setCustomerDto(CustomerDto customerDto) {
		this.customerDto = customerDto;
	}

}
