package com.mx.web.app.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tb_insurancetype database table.
 * 
 */
@Entity
@Table(name="tb_insurancetype")
@NamedQuery(name="TbInsurancetype.findAll", query="SELECT t FROM TbInsurancetype t")
public class TbInsurancetype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long insuranceTypeID;

	private String insuranceName;

	//bi-directional many-to-one association to TbInsurance
	@OneToMany(mappedBy="tbInsurancetype")
	private List<TbInsurance> tbInsurances;

	public TbInsurancetype() {
	}

	public long getInsuranceTypeID() {
		return this.insuranceTypeID;
	}

	public void setInsuranceTypeID(long insuranceTypeID) {
		this.insuranceTypeID = insuranceTypeID;
	}

	public String getInsuranceName() {
		return this.insuranceName;
	}

	public void setInsuranceName(String insuranceName) {
		this.insuranceName = insuranceName;
	}

	public List<TbInsurance> getTbInsurances() {
		return this.tbInsurances;
	}

	public void setTbInsurances(List<TbInsurance> tbInsurances) {
		this.tbInsurances = tbInsurances;
	}

	public TbInsurance addTbInsurance(TbInsurance tbInsurance) {
		getTbInsurances().add(tbInsurance);
		tbInsurance.setTbInsurancetype(this);

		return tbInsurance;
	}

	public TbInsurance removeTbInsurance(TbInsurance tbInsurance) {
		getTbInsurances().remove(tbInsurance);
		tbInsurance.setTbInsurancetype(null);

		return tbInsurance;
	}

}