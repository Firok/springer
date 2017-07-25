package com.firok.springer.dao;

import com.firok.springer.entity.Company;

/**
 * Company repository
 * 
 * @author Firok
 * @since 7/24/2017
 */
public interface CompanyDao extends BaseDao<Company, Long> {

	/**
	 * Method repository to check if the company already exists as the company
	 * name is unique
	 * 
	 * @param companyName
	 * @return true if company exists otherwise false
	 */
	boolean companyExists(String companyName);

}
