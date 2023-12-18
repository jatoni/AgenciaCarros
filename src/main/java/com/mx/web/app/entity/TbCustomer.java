package com.mx.web.app.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tb_customer database table.
 * 
 */
@Entity
@Table(name="tb_customer")
@NamedQuery(name="TbCustomer.findAll", query="SELECT t FROM TbCustomer t")
public class TbCustomer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long customerID;

	private String address;

	private String city;

	private String email;

	private String lastname;

	private String name;

	private int phone;

	private String postalCode;

	private String state;

	//bi-directional many-to-one association to TbSale
	@OneToMany(mappedBy="tbCustomer")
	private List<TbSale> tbSales;

	public TbCustomer() {
	}

	public long getCustomerID() {
		return this.customerID;
	}

	public void setCustomerID(long customerID) {
		this.customerID = customerID;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPhone() {
		return this.phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getPostalCode() {
		return this.postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public List<TbSale> getTbSales() {
		return this.tbSales;
	}

	public void setTbSales(List<TbSale> tbSales) {
		this.tbSales = tbSales;
	}

	public TbSale addTbSale(TbSale tbSale) {
		getTbSales().add(tbSale);
		tbSale.setTbCustomer(this);

		return tbSale;
	}

	public TbSale removeTbSale(TbSale tbSale) {
		getTbSales().remove(tbSale);
		tbSale.setTbCustomer(null);

		return tbSale;
	}

}