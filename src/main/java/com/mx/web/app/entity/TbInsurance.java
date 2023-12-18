package com.mx.web.app.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the tb_insurance database table.
 * 
 */
@Entity
@Table(name="tb_insurance")
@NamedQuery(name="TbInsurance.findAll", query="SELECT t FROM TbInsurance t")
public class TbInsurance implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long insuranceID;

	private String company;

	private String coverage;

	@Temporal(TemporalType.DATE)
	private Date expirationDate;

	//bi-directional many-to-one association to TbInsurancetype
	@ManyToOne
	@JoinColumn(name="insuranceTypeID")
	private TbInsurancetype tbInsurancetype;

	//bi-directional many-to-one association to TbVehicle
	@ManyToOne
	@JoinColumn(name="vehicleID")
	private TbVehicle tbVehicle;

	public TbInsurance() {
	}

	public long getInsuranceID() {
		return this.insuranceID;
	}

	public void setInsuranceID(long insuranceID) {
		this.insuranceID = insuranceID;
	}

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getCoverage() {
		return this.coverage;
	}

	public void setCoverage(String coverage) {
		this.coverage = coverage;
	}

	public Date getExpirationDate() {
		return this.expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public TbInsurancetype getTbInsurancetype() {
		return this.tbInsurancetype;
	}

	public void setTbInsurancetype(TbInsurancetype tbInsurancetype) {
		this.tbInsurancetype = tbInsurancetype;
	}

	public TbVehicle getTbVehicle() {
		return this.tbVehicle;
	}

	public void setTbVehicle(TbVehicle tbVehicle) {
		this.tbVehicle = tbVehicle;
	}

}