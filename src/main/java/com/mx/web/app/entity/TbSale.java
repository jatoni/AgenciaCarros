package com.mx.web.app.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the tb_sale database table.
 * 
 */
@Entity
@Table(name="tb_sale")
@NamedQuery(name="TbSale.findAll", query="SELECT t FROM TbSale t")
public class TbSale implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long saleID;

	private String comments;

	@Temporal(TemporalType.DATE)
	private Date saleDate;

	private int salePrice;

	//bi-directional many-to-one association to TbCustomer
	@ManyToOne
	@JoinColumn(name="customerID")
	private TbCustomer tbCustomer;

	//bi-directional many-to-one association to TbEmployee
	@ManyToOne
	@JoinColumn(name="employeeID")
	private TbEmployee tbEmployee;

	//bi-directional many-to-one association to TbPaymentmethod
	@ManyToOne
	@JoinColumn(name="paymentMehotdID")
	private TbPaymentmethod tbPaymentmethod;

	//bi-directional many-to-one association to TbVehicle
	@ManyToOne
	@JoinColumn(name="vehicleID")
	private TbVehicle tbVehicle;

	public TbSale() {
	}

	public long getSaleID() {
		return this.saleID;
	}

	public void setSaleID(long saleID) {
		this.saleID = saleID;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Date getSaleDate() {
		return this.saleDate;
	}

	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}

	public int getSalePrice() {
		return this.salePrice;
	}

	public void setSalePrice(int salePrice) {
		this.salePrice = salePrice;
	}

	public TbCustomer getTbCustomer() {
		return this.tbCustomer;
	}

	public void setTbCustomer(TbCustomer tbCustomer) {
		this.tbCustomer = tbCustomer;
	}

	public TbEmployee getTbEmployee() {
		return this.tbEmployee;
	}

	public void setTbEmployee(TbEmployee tbEmployee) {
		this.tbEmployee = tbEmployee;
	}

	public TbPaymentmethod getTbPaymentmethod() {
		return this.tbPaymentmethod;
	}

	public void setTbPaymentmethod(TbPaymentmethod tbPaymentmethod) {
		this.tbPaymentmethod = tbPaymentmethod;
	}

	public TbVehicle getTbVehicle() {
		return this.tbVehicle;
	}

	public void setTbVehicle(TbVehicle tbVehicle) {
		this.tbVehicle = tbVehicle;
	}

}