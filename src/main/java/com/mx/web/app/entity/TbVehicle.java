package com.mx.web.app.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tb_vehicle database table.
 * 
 */
@Entity
@Table(name="tb_vehicle")
@NamedQuery(name="TbVehicle.findAll", query="SELECT t FROM TbVehicle t")
public class TbVehicle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long vehicleID;

	private String description;

	private String fuelType;

	@Lob
	private byte[] imageVehicle;

	private String model;

	private int price;

	private int stockQuantity;

	@Temporal(TemporalType.DATE)
	private Date year;

	//bi-directional many-to-one association to TbInsurance
	@OneToMany(mappedBy="tbVehicle")
	private List<TbInsurance> tbInsurances;

	//bi-directional many-to-one association to TbMaintenance
	@OneToMany(mappedBy="tbVehicle")
	private List<TbMaintenance> tbMaintenances;

	//bi-directional many-to-one association to TbSale
	@OneToMany(mappedBy="tbVehicle")
	private List<TbSale> tbSales;

	//bi-directional many-to-one association to TbBrand
	@ManyToOne
	@JoinColumn(name="brandID")
	private TbBrand tbBrand;

	//bi-directional many-to-one association to TbColor
	@ManyToOne
	@JoinColumn(name="colorID")
	private TbColor tbColor;

	//bi-directional many-to-one association to TbTransmission
	@ManyToOne
	@JoinColumn(name="transmissionID")
	private TbTransmission tbTransmission;

	public TbVehicle() {
	}

	public long getVehicleID() {
		return this.vehicleID;
	}

	public void setVehicleID(long vehicleID) {
		this.vehicleID = vehicleID;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFuelType() {
		return this.fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public byte[] getImageVehicle() {
		return this.imageVehicle;
	}

	public void setImageVehicle(byte[] imageVehicle) {
		this.imageVehicle = imageVehicle;
	}

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStockQuantity() {
		return this.stockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	public Date getYear() {
		return this.year;
	}

	public void setYear(Date year) {
		this.year = year;
	}

	public List<TbInsurance> getTbInsurances() {
		return this.tbInsurances;
	}

	public void setTbInsurances(List<TbInsurance> tbInsurances) {
		this.tbInsurances = tbInsurances;
	}

	public TbInsurance addTbInsurance(TbInsurance tbInsurance) {
		getTbInsurances().add(tbInsurance);
		tbInsurance.setTbVehicle(this);

		return tbInsurance;
	}

	public TbInsurance removeTbInsurance(TbInsurance tbInsurance) {
		getTbInsurances().remove(tbInsurance);
		tbInsurance.setTbVehicle(null);

		return tbInsurance;
	}

	public List<TbMaintenance> getTbMaintenances() {
		return this.tbMaintenances;
	}

	public void setTbMaintenances(List<TbMaintenance> tbMaintenances) {
		this.tbMaintenances = tbMaintenances;
	}

	public TbMaintenance addTbMaintenance(TbMaintenance tbMaintenance) {
		getTbMaintenances().add(tbMaintenance);
		tbMaintenance.setTbVehicle(this);

		return tbMaintenance;
	}

	public TbMaintenance removeTbMaintenance(TbMaintenance tbMaintenance) {
		getTbMaintenances().remove(tbMaintenance);
		tbMaintenance.setTbVehicle(null);

		return tbMaintenance;
	}

	public List<TbSale> getTbSales() {
		return this.tbSales;
	}

	public void setTbSales(List<TbSale> tbSales) {
		this.tbSales = tbSales;
	}

	public TbSale addTbSale(TbSale tbSale) {
		getTbSales().add(tbSale);
		tbSale.setTbVehicle(this);

		return tbSale;
	}

	public TbSale removeTbSale(TbSale tbSale) {
		getTbSales().remove(tbSale);
		tbSale.setTbVehicle(null);

		return tbSale;
	}

	public TbBrand getTbBrand() {
		return this.tbBrand;
	}

	public void setTbBrand(TbBrand tbBrand) {
		this.tbBrand = tbBrand;
	}

	public TbColor getTbColor() {
		return this.tbColor;
	}

	public void setTbColor(TbColor tbColor) {
		this.tbColor = tbColor;
	}

	public TbTransmission getTbTransmission() {
		return this.tbTransmission;
	}

	public void setTbTransmission(TbTransmission tbTransmission) {
		this.tbTransmission = tbTransmission;
	}

}