/**
 * 
 */
package com.mx.web.app.dao;

import com.mx.web.app.dto.EmployeeDto;

/**
 * @author jat_a
 * 
 *         Interface para el manejo de CRUD
 */
public interface TbEmployeeDao {

	/**
	 * @param usuario  {@link String} parametro que el usuario ingreso para hacer
	 *                 sesion
	 * @param password {@link String} parametro que el usuario ingreso para hacer
	 *                 sesion
	 * @return
	 */
	boolean login(String usuario, String password);

	/**
	 * @param employeeDto {@link EmployeeDto} parametro de tipo objeto donde el
	 *                    usuario llena en el formulario
	 * @return {@link Boolean} Retorna un valor boolean
	 */
	boolean saveEmployee(EmployeeDto employeeDto);
}
