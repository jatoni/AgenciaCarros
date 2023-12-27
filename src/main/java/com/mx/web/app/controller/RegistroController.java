/**
 * 
 */
package com.mx.web.app.controller;

import java.io.InputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;
import org.primefaces.util.IOUtils;

import com.mx.web.app.dao.TbCustomerDao;
import com.mx.web.app.dao.TbEmployeeDao;
import com.mx.web.app.dao.TbPositionDao;
import com.mx.web.app.dto.CustomerDto;
import com.mx.web.app.dto.EmployeeDto;
import com.mx.web.app.entity.TbPosition;
import com.mx.web.app.utils.CommonUtils;

/**
 * @author jat_a
 * 
 *         Controlador para el manejo de guardar clientes en vistas
 */

@Named
@SessionScoped
public class RegistroController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9180958871052015855L;

	@Inject
	private CustomerDto customerDto;

	@Inject
	private TbCustomerDao cusTbCustomerDaoImpl;

	@Inject
	private TbPositionDao tbPositionDaoImpl;

	private byte[] imagen;

	@Inject
	private TbEmployeeDao tbEmployeeDaoImpl;

	@Inject
	private EmployeeDto employeeDto;

	private Date selectedDate;

	private Date currentDate;

	@PostConstruct
	public void init() {
		System.out.println("Se empieza");
		this.AllPositionsController();
		selectedDate = new Date();
		currentDate = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
	}

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
	 * @return {@link List} Retorna una lista de los puestos de trabajo disponibles
	 */
	public List<TbPosition> AllPositionsController() {
		return this.tbPositionDaoImpl.getAllPositions();
	}

	public void saveEmployee() {
		try {
			System.out.println(imagen);
			employeeDto.setImagenEmployeee(imagen);
			if (tbEmployeeDaoImpl.saveEmployee(employeeDto)) {
				CommonUtils.showMessage(FacesMessage.SEVERITY_INFO, "Exito", "Se guardo con exito el cliente");
				employeeDto = null;
			} else {
				CommonUtils.showMessage(FacesMessage.SEVERITY_ERROR, "Ups!!", "El usuario no se pudo guardar");
			}
		} catch (Exception e) {
			e.printStackTrace();
			CommonUtils.showMessage(FacesMessage.SEVERITY_ERROR, "Error al guardar la foto", "");
		}
	}

	public void handleFileUpload(FileUploadEvent event) {
		UploadedFile uploadedFile = event.getFile();
		try (InputStream input = uploadedFile.getInputStream()) {
			imagen = IOUtils.toByteArray(input);
		} catch (Exception e) {
			e.printStackTrace();
			CommonUtils.showMessage(FacesMessage.SEVERITY_ERROR, "Error al convertir el archivo a bytes", "");
		}
		this.imagen = uploadedFile.getContent();
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

	/**
	 * @return the imagen
	 */
	public byte[] getImagen() {
		return imagen;
	}

	/**
	 * @param imagen the imagen to set
	 */
	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

	/**
	 * @return the employeeDto
	 */
	public EmployeeDto getEmployeeDto() {
		return employeeDto;
	}

	/**
	 * @param employeeDto the employeeDto to set
	 */
	public void setEmployeeDto(EmployeeDto employeeDto) {
		this.employeeDto = employeeDto;
	}

	/**
	 * @return the selectedDate
	 */
	public Date getSelectedDate() {
		return selectedDate;
	}

	/**
	 * @param selectedDate the selectedDate to set
	 */
	public void setSelectedDate(Date selectedDate) {
		this.selectedDate = selectedDate;
	}

	/**
	 * @return the currentDate
	 */
	public Date getCurrentDate() {
		return currentDate;
	}

	/**
	 * @param currentDate the currentDate to set
	 */
	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}

}
