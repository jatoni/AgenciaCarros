/**
 * 
 */
package com.mx.web.app.dao.impl;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.mx.web.app.dao.TbEmployeeDao;
import com.mx.web.app.dto.EmployeeDto;
import com.mx.web.app.entity.TbEmployee;
import com.mx.web.app.utils.CommonUtils;

/**
 * @author jat_a
 * 
 *         clase para el manejo de capa de datos
 */
public class TbEmployeeDaoImpl implements TbEmployeeDao, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2734337936902895624L;

	private EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("VelocidadTotal");

	private TbEmployee employee = new TbEmployee();

	private EmployeeDto employeeDto = new EmployeeDto();

	private EntityTransaction et;

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

	@Override
	public boolean saveEmployee(EmployeeDto employeeDto) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		et = em.getTransaction();
		TbEmployee employeeToSave = CommonUtils.map(employeeDto, employee);
		try {
			et.begin();
			em.persist(employeeToSave);
			et.commit();
			return true;
		} catch (Exception e) {
			if (Objects.isNull(et)) {
				et.rollback();
			}
			e.printStackTrace();
			return false;
		} finally {
			em.close();
		}
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {

		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		TypedQuery<TbEmployee> employees = em.createNamedQuery("TbEmployee.findAll", TbEmployee.class);
		List<EmployeeDto> employeesDto = employees.getResultList().stream()
				.map(employee -> CommonUtils.map(employee, employeeDto)).toList();
		return employeesDto;
	}

}
