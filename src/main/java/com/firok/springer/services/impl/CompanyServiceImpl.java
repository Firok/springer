package com.firok.springer.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firok.springer.dao.BaseDao;
import com.firok.springer.dao.CompanyDao;
import com.firok.springer.entity.Company;
import com.firok.springer.services.CompanyService;

/**
 * Company service implementation
 * 
 * @author Firok
 * @since 7/24/2017
 */
@Service
public class CompanyServiceImpl extends BaseServiceImpl<Company, Long> implements CompanyService {

	@Autowired
	private CompanyDao companyDao;

	@Override
	protected BaseDao<Company, Long> getDao() {
		return companyDao;
	}

	/**
	 * Method Service to add a new company.  
	 * @param company
	 * @return true if company is added and false if the company already exists in the database
	 */
	@Override
	public synchronized boolean addCompany(Company company) {
		// if company exists return false
		if (companyDao.companyExists(company.getCompanyName()))
			return false;
		else {
			// Here the company does not exist, then save a new record
			companyDao.create(company);
			return true;
		}
	}

}
