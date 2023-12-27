/**
 * 
 */
package com.mx.web.app.dao;

import java.util.List;

import com.mx.web.app.entity.TbPosition;

/**
 * 
 */
public interface TbPositionDao {
	/**
	 * @return {@link List} Retorna una lista de todas las posiciones
	 */
	List<TbPosition> getAllPositions();

	TbPosition getPositionById(long id);
}
