package com.mx.web.app.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.List;

/**
 * The persistent class for the tb_position database table.
 * 
 */
@Entity
@Table(name = "tb_position")
@NamedQueries({ @NamedQuery(name = "TbPosition.findAll", query = "SELECT t FROM TbPosition t"),
		@NamedQuery(name = "TbPosition.finByEmail", query = "SELECT t FROM TbPosition t WHERE t.positionID = :id") })
public class TbPosition implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long positionID;

	private Time departureTime;

	private Time entryTime;

	private String name;

	private int salary;

	// bi-directional many-to-one association to TbEmployee
	@OneToMany(mappedBy = "tbPosition")
	private List<TbEmployee> tbEmployees;

	public TbPosition() {
	}

	public long getPositionID() {
		return this.positionID;
	}

	public void setPositionID(long positionID) {
		this.positionID = positionID;
	}

	public Time getDepartureTime() {
		return this.departureTime;
	}

	public void setDepartureTime(Time departureTime) {
		this.departureTime = departureTime;
	}

	public Time getEntryTime() {
		return this.entryTime;
	}

	public void setEntryTime(Time entryTime) {
		this.entryTime = entryTime;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return this.salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public List<TbEmployee> getTbEmployees() {
		return this.tbEmployees;
	}

	public void setTbEmployees(List<TbEmployee> tbEmployees) {
		this.tbEmployees = tbEmployees;
	}

	public TbEmployee addTbEmployee(TbEmployee tbEmployee) {
		getTbEmployees().add(tbEmployee);
		tbEmployee.setTbPosition(this);

		return tbEmployee;
	}

	public TbEmployee removeTbEmployee(TbEmployee tbEmployee) {
		getTbEmployees().remove(tbEmployee);
		tbEmployee.setTbPosition(null);

		return tbEmployee;
	}

}