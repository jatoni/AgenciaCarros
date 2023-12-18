/**
 * 
 */
package com.mx.web.app.dao;

/**
 * @author jat_a
 * 
 *         Interface para el manejo de CRUD
 */
public interface TbEmployeeDao {

	/**
	 * @param usuario  {@link String}
	 * @param password {@link String}
	 * @return
	 */
	boolean login(String usuario, String password);
}
