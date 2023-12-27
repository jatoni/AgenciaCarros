/**
 * 
 */
package com.mx.web.app.dao.impl;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.mx.web.app.dao.TbCustomerDao;
import com.mx.web.app.dto.CustomerDto;
import com.mx.web.app.entity.TbCustomer;
import com.mx.web.app.utils.CommonUtils;

/**
 * 
 */
public class TbCustomerDaoImpl implements TbCustomerDao, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5510974353736873906L;

	private TbCustomer custonmer = new TbCustomer();
	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
			.createEntityManagerFactory("VelocidadTotal");

	@Override
	public boolean inserCustomer(CustomerDto customerDto) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et = em.getTransaction();
		TbCustomer customerToAdd = CommonUtils.map(customerDto, custonmer);
		try {
			et.begin();
			em.persist(customerToAdd);
			et.commit();
			return true;
		} catch (Exception e) {
			if (et != null) {
				et.rollback();
			}
			e.printStackTrace();
			return false;
		} finally {
			em.close();
		}
	}

}
