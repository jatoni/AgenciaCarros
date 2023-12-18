package com.mx.web.app.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tb_transmission database table.
 * 
 */
@Entity
@Table(name="tb_transmission")
@NamedQuery(name="TbTransmission.findAll", query="SELECT t FROM TbTransmission t")
public class TbTransmission implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long transmissionID;

	private String name;

	//bi-directional many-to-one association to TbVehicle
	@OneToMany(mappedBy="tbTransmission")
	private List<TbVehicle> tbVehicles;

	public TbTransmission() {
	}

	public long getTransmissionID() {
		return this.transmissionID;
	}

	public void setTransmissionID(long transmissionID) {
		this.transmissionID = transmissionID;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<TbVehicle> getTbVehicles() {
		return this.tbVehicles;
	}

	public void setTbVehicles(List<TbVehicle> tbVehicles) {
		this.tbVehicles = tbVehicles;
	}

	public TbVehicle addTbVehicle(TbVehicle tbVehicle) {
		getTbVehicles().add(tbVehicle);
		tbVehicle.setTbTransmission(this);

		return tbVehicle;
	}

	public TbVehicle removeTbVehicle(TbVehicle tbVehicle) {
		getTbVehicles().remove(tbVehicle);
		tbVehicle.setTbTransmission(null);

		return tbVehicle;
	}

}