/**
 * 
 */
package com.mx.web.app.dao.impl;

import javax.persistence.EntityManagerFactory;

import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.mx.web.app.dao.TbEmployeeDao;
import com.mx.web.app.entity.TbEmployee;

/**
 * @author jat_a
 * 
 *         clase para el manejo de capa de datos
 */
public class TbEmployeeDaoImpl implements TbEmployeeDao {

	private EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("VelocidadTotal");

	@Override
	public boolean login(String usuario, String password) {
		try {
			EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
			TypedQuery<TbEmployee> query = em.createNamedQuery("TbEmployee.findByemailPassword", TbEmployee.class);
			query.setParameter("email", usuario);
			query.setParameter("password", password);
			if (!query.getResultList().isEmpty() && !Objects.isNull(query)) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

}
