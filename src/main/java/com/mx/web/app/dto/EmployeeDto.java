/**
 * 
 */
package com.mx.web.app.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Lob;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.mx.web.app.entity.TbPosition;

/**
 * 
 */
public class EmployeeDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -947002802740308383L;

	private long employeeID;

	@NotEmpty
	@NotBlank
	@NotNull
	@Size(min = 10, max = 100, message = "El correo no puede ser mayor a 100 o menor a 10")
	@Email(message = "Solo se aceptan correos")
	private String email;

	@NotEmpty
	@NotBlank
	@NotNull
	@Size(max = 50)
	private String firstname;

	@NotEmpty
	@NotBlank
	@NotNull
	private Date hireDate;

	@Lob
	@NotEmpty
	@NotBlank
	@NotNull
	private byte[] imagenEmployeee;

	@NotEmpty
	@NotBlank
	@NotNull
	@Size(max = 50)
	private String lastName;

	@NotEmpty
	@NotBlank
	@NotNull
	@Size(max = 15)
	private String password;

	@NotEmpty
	@NotBlank
	@NotNull
	@Size(min = 10, max = 10, message = "Los numeros deben de ser de 10 digitos")
	@Pattern(regexp = "[0-9]*", message = "Solo se aceptan valores numericos")
	private String phone;

	@NotEmpty
	@NotBlank
	@NotNull
	private TbPosition tbPosition;

	/**
	 * @return the employeeID
	 */
	public long getEmployeeID() {
		return employeeID;
	}

	/**
	 * @param employeeID the employeeID to set
	 */
	public void setEmployeeID(long employeeID) {
		this.employeeID = employeeID;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @return the hireDate
	 */
	public Date getHireDate() {
		return hireDate;
	}

	/**
	 * @param hireDate the hireDate to set
	 */
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	/**
	 * @return the imagenEmployeee
	 */
	public byte[] getImagenEmployeee() {
		return imagenEmployeee;
	}

	/**
	 * @param imagenEmployeee the imagenEmployeee to set
	 */
	public void setImagenEmployeee(byte[] imagenEmployeee) {
		this.imagenEmployeee = imagenEmployeee;
	}

	/**
	 * @return the lasName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lasName the lasName to set
	 */
	public void setLastName(String lasName) {
		this.lastName = lasName;
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

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the tbPosition
	 */
	public TbPosition getTbPosition() {
		return tbPosition;
	}

	/**
	 * @param tbPosition the tbPosition to set
	 */
	public void setTbPosition(TbPosition tbPosition) {
		this.tbPosition = tbPosition;
	}

}
