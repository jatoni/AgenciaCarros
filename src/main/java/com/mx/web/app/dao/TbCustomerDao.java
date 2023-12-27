/**
 * 
 */
package com.mx.web.app.dao;

import com.mx.web.app.dto.CustomerDto;

/**
 * @author jat_a
 * 
 *         interface para el control
 */
public interface TbCustomerDao {
	
	
	/**
	 * @return {@link Boolean}
	 */
	boolean inserCustomer(CustomerDto customerDto);
}
