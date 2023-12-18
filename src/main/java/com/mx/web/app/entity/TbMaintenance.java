package com.mx.web.app.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the tb_maintenance database table.
 * 
 */
@Entity
@Table(name="tb_maintenance")
@NamedQuery(name="TbMaintenance.findAll", query="SELECT t FROM TbMaintenance t")
public class TbMaintenance implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long maintenanceID;

	private int cost;

	private String description;

	@Temporal(TemporalType.DATE)
	private Date maintenanceDate;

	//bi-directional many-to-one association to TbVehicle
	@ManyToOne
	@JoinColumn(name="vehicleID")
	private TbVehicle tbVehicle;

	public TbMaintenance() {
	}

	public long getMaintenanceID() {
		return this.maintenanceID;
	}

	public void setMaintenanceID(long maintenanceID) {
		this.maintenanceID = maintenanceID;
	}

	public int getCost() {
		return this.cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getMaintenanceDate() {
		return this.maintenanceDate;
	}

	public void setMaintenanceDate(Date maintenanceDate) {
		this.maintenanceDate = maintenanceDate;
	}

	public TbVehicle getTbVehicle() {
		return this.tbVehicle;
	}

	public void setTbVehicle(TbVehicle tbVehicle) {
		this.tbVehicle = tbVehicle;
	}

}