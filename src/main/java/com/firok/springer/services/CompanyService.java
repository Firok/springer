package com.firok.springer.services;

import com.firok.springer.entity.Company;

/**
 * Company service
 * @author Firok
 * @since 7/24/2017
 */
public interface CompanyService extends BaseService<Company,Long>{
   
	/**
	 * Method Service to add a new company.  
	 * @param company
	 * @return true if company is added and false if the company already exists in the database
	 */
	boolean addCompany(Company company);
}
       