package com.mx.web.app.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the tb_employee database table.
 * 
 */
@Entity
@Table(name = "tb_employee")
@NamedQueries({ @NamedQuery(name = "TbEmployee.findAll", query = "SELECT t FROM TbEmployee t"),
		@NamedQuery(name = "TbEmployee.findByemailPassword", query = "SELECT t FROM TbEmployee t WHERE t.email=:email AND t.password=:password") })
public class TbEmployee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long employeeID;

	private String email;

	private String firstName;

	@Temporal(TemporalType.DATE)
	private Date hireDate;

	@Lob
	private byte[] imagenEmployee;

	private String lastName;

	private String password;

	private String phone;

	// bi-directional many-to-one association to TbPosition
	@ManyToOne
	@JoinColumn(name = "positionID")
	private TbPosition tbPosition;

	// bi-directional many-to-one association to TbSale
	@OneToMany(mappedBy = "tbEmployee")
	private List<TbSale> tbSales;

	public TbEmployee() {
	}

	public long getEmployeeID() {
		return this.employeeID;
	}

	public void setEmployeeID(long employeeID) {
		this.employeeID = employeeID;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Date getHireDate() {
		return this.hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public byte[] getImagenEmployee() {
		return this.imagenEmployee;
	}

	public void setImagenEmployee(byte[] imagenEmployee) {
		this.imagenEmployee = imagenEmployee;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public TbPosition getTbPosition() {
		return this.tbPosition;
	}

	public void setTbPosition(TbPosition tbPosition) {
		this.tbPosition = tbPosition;
	}

	public List<TbSale> getTbSales() {
		return this.tbSales;
	}

	public void setTbSales(List<TbSale> tbSales) {
		this.tbSales = tbSales;
	}

	public TbSale addTbSale(TbSale tbSale) {
		getTbSales().add(tbSale);
		tbSale.setTbEmployee(this);

		return tbSale;
	}

	public TbSale removeTbSale(TbSale tbSale) {
		getTbSales().remove(tbSale);
		tbSale.setTbEmployee(null);

		return tbSale;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TbEmployee [employeeID=");
		builder.append(employeeID);
		builder.append(", email=");
		builder.append(email);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", hireDate=");
		builder.append(hireDate);
		builder.append(", imagenEmployee=");
		builder.append(Arrays.toString(imagenEmployee));
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", password=");
		builder.append(password);
		builder.append(", phone=");
		builder.append(phone);
		builder.append(", tbPosition=");
		builder.append(tbPosition);
		builder.append(", tbSales=");
		builder.append(tbSales);
		builder.append("]");
		return builder.toString();
	}

}