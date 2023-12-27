/**
 * 
 */
package com.mx.web.app.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * 
 */
public class CustomerDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1062034211136323306L;

	@NotNull
	@NotEmpty
	@Size(min = 10, max = 100)
	private String address;

	@NotNull
	@NotEmpty
	@Size(min = 10, max = 100)
	private String city;

	@Email
	@NotNull
	@NotEmpty
	@Size(max = 50)
	private String email;

	@NotEmpty
	@NotNull
	@Size(max = 50)
	private String lastname;

	@NotNull
	@NotEmpty
	@Size(max = 50)
	private String name;

	@NotNull
	@NotEmpty
	@Size(min = 10, max = 10, message = "Los numeros deben de ser de 10 digitos")
	@Pattern(regexp = "[0-9]*", message = "Solo se aceptan valores numericos")
	@Size(max = 50)
	private String phone;

	@NotNull
	@NotEmpty
	@Size(max = 20)
	private String postalCode;

	@NotNull
	@NotEmpty
	@Size(max = 20)
	private String state;

	/**
	 * @return the addres
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param addres the addres to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
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
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
	 * @return the postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * @param postalCode the postalCode to set
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return this.state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
}
