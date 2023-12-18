package com.mx.web.app.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tb_paymentmethod database table.
 * 
 */
@Entity
@Table(name="tb_paymentmethod")
@NamedQuery(name="TbPaymentmethod.findAll", query="SELECT t FROM TbPaymentmethod t")
public class TbPaymentmethod implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long paymentMehotdID;

	private String name;

	//bi-directional many-to-one association to TbSale
	@OneToMany(mappedBy="tbPaymentmethod")
	private List<TbSale> tbSales;

	public TbPaymentmethod() {
	}

	public long getPaymentMehotdID() {
		return this.paymentMehotdID;
	}

	public void setPaymentMehotdID(long paymentMehotdID) {
		this.paymentMehotdID = paymentMehotdID;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<TbSale> getTbSales() {
		return this.tbSales;
	}

	public void setTbSales(List<TbSale> tbSales) {
		this.tbSales = tbSales;
	}

	public TbSale addTbSale(TbSale tbSale) {
		getTbSales().add(tbSale);
		tbSale.setTbPaymentmethod(this);

		return tbSale;
	}

	public TbSale removeTbSale(TbSale tbSale) {
		getTbSales().remove(tbSale);
		tbSale.setTbPaymentmethod(null);

		return tbSale;
	}

}