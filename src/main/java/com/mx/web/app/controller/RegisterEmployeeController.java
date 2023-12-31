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

import com.mx.web.app.dao.TbEmployeeDao;
import com.mx.web.app.dao.TbPositionDao;
import com.mx.web.app.dto.EmployeeDto;
import com.mx.web.app.entity.TbPosition;
import com.mx.web.app.utils.CommonUtils;

/**
 * @author jat_a
 * 
 * 
 */

@Named
@SessionScoped
public class RegisterEmployeeController implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7086069056493718895L;

	@Inject
	private EmployeeDto employeeDto;

	@Inject
	private TbEmployeeDao tbEmployeeDaoImpl;

	@Inject
	private TbPositionDao tbPositionDaoImpl;

	private Date selectedDate;

	private Date currentDate;

	private int itemSelected;

	private byte[] imagen;

	private List<TbPosition> listPosition;

	@PostConstruct
	public void init() {
		this.listPosition = tbPositionDaoImpl.getAllPositions();
		System.out.println(this.listPosition);
		selectedDate = new Date();
		currentDate = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
	}

	public void saveEmployee() {
		try {
			System.out.println(itemSelected);
			employeeDto.setImagenEmployeee(imagen);
			employeeDto.setTbPosition(this.listPosition.get(itemSelected - 1));
			employeeDto.setHireDate(selectedDate);
			if (tbEmployeeDaoImpl.saveEmployee(employeeDto)) {
				CommonUtils.showMessage(FacesMessage.SEVERITY_INFO, "Exito", "Se guardo con exito el cliente");
				employeeDto = new EmployeeDto();
			} else {
				CommonUtils.showMessage(FacesMessage.SEVERITY_ERROR, "Ups!!", "El usuario no se pudo guardar");
			}
		} catch (Exception e) {
			e.printStackTrace();
			CommonUtils.showMessage(FacesMessage.SEVERITY_ERROR, "Error al guardar al empleado", "");
		}
	}

	/**
	 * @return {@link List} Retorna una lista de los puestos de trabajo disponibles
	 */
	public List<TbPosition> AllPositionsController() {
		return this.listPosition;
	}

	public void handleFileUpload(FileUploadEvent event) {
		UploadedFile uploadedFile = event.getFile();
		try (InputStream input = uploadedFile.getInputStream()) {
			imagen = IOUtils.toByteArray(input);
			this.imagen = uploadedFile.getContent();
		} catch (Exception e) {
			e.printStackTrace();
			CommonUtils.showMessage(FacesMessage.SEVERITY_ERROR, "Error al convertir el archivo a bytes", "");
		}
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

	/**
	 * @return the itemSelected
	 */
	public int getItemSelected() {
		return itemSelected;
	}

	/**
	 * @param itemSelected the itemSelected to set
	 */
	public void setItemSelected(int itemSelected) {
		this.itemSelected = itemSelected;
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
	 * @return the listPosition
	 */
	public List<TbPosition> getListPosition() {
		return listPosition;
	}

	/**
	 * @param listPosition the listPosition to set
	 */
	public void setListPosition(List<TbPosition> listPosition) {
		this.listPosition = listPosition;
	}

}
