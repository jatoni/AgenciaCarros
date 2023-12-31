/**
 * 
 */
package com.mx.web.app.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.mx.web.app.dao.TbPositionDao;

import com.mx.web.app.entity.TbPosition;

/**
 * 
 */
public class TbPositionDaoImpl implements TbPositionDao, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7387772855088541767L;

	private EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("VelocidadTotal");

	@Override
	public List<TbPosition> getAllPositions() {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		TypedQuery<TbPosition> query = em.createNamedQuery("TbPosition.findAll", TbPosition.class);
		return query.getResultList();
	}

	/**
	 *
	 */
	@Override
	public TbPosition getPositionById(long id) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		try {
			return em.find(TbPosition.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
