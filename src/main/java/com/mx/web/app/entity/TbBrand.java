package com.mx.web.app.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tb_brand database table.
 * 
 */
@Entity
@Table(name="tb_brand")
@NamedQuery(name="TbBrand.findAll", query="SELECT t FROM TbBrand t")
public class TbBrand implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long brandID;

	private String brandName;

	private String countryOfOrigin;

	//bi-directional many-to-one association to TbVehicle
	@OneToMany(mappedBy="tbBrand")
	private List<TbVehicle> tbVehicles;

	public TbBrand() {
	}

	public long getBrandID() {
		return this.brandID;
	}

	public void setBrandID(long brandID) {
		this.brandID = brandID;
	}

	public String getBrandName() {
		return this.brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getCountryOfOrigin() {
		return this.countryOfOrigin;
	}

	public void setCountryOfOrigin(String countryOfOrigin) {
		this.countryOfOrigin = countryOfOrigin;
	}

	public List<TbVehicle> getTbVehicles() {
		return this.tbVehicles;
	}

	public void setTbVehicles(List<TbVehicle> tbVehicles) {
		this.tbVehicles = tbVehicles;
	}

	public TbVehicle addTbVehicle(TbVehicle tbVehicle) {
		getTbVehicles().add(tbVehicle);
		tbVehicle.setTbBrand(this);

		return tbVehicle;
	}

	public TbVehicle removeTbVehicle(TbVehicle tbVehicle) {
		getTbVehicles().remove(tbVehicle);
		tbVehicle.setTbBrand(null);

		return tbVehicle;
	}

}