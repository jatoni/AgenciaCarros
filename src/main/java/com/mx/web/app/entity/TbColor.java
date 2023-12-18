package com.mx.web.app.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tb_color database table.
 * 
 */
@Entity
@Table(name="tb_color")
@NamedQuery(name="TbColor.findAll", query="SELECT t FROM TbColor t")
public class TbColor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long colorID;

	private String colorName;

	//bi-directional many-to-one association to TbVehicle
	@OneToMany(mappedBy="tbColor")
	private List<TbVehicle> tbVehicles;

	public TbColor() {
	}

	public long getColorID() {
		return this.colorID;
	}

	public void setColorID(long colorID) {
		this.colorID = colorID;
	}

	public String getColorName() {
		return this.colorName;
	}

	public void setColorName(String colorName) {
		this.colorName = colorName;
	}

	public List<TbVehicle> getTbVehicles() {
		return this.tbVehicles;
	}

	public void setTbVehicles(List<TbVehicle> tbVehicles) {
		this.tbVehicles = tbVehicles;
	}

	public TbVehicle addTbVehicle(TbVehicle tbVehicle) {
		getTbVehicles().add(tbVehicle);
		tbVehicle.setTbColor(this);

		return tbVehicle;
	}

	public TbVehicle removeTbVehicle(TbVehicle tbVehicle) {
		getTbVehicles().remove(tbVehicle);
		tbVehicle.setTbColor(null);

		return tbVehicle;
	}

}