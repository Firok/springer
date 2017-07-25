package com.firok.springer.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.firok.springer.dao.CompanyDao;
import com.firok.springer.entity.Company;

/**
 * Company repository implementation
 * @author firok
 * @since 7/24/2017
 */
@Transactional
@Repository
public class CompanyDaoImpl extends BaseDaoImpl<Company, Long> implements CompanyDao {

	public CompanyDaoImpl() {
		super(Company.class);
	}

	/**
	 * Method repository to check if the company already exists as the company name is unique  
	 * @param companyName
	 * @return true if company exists otherwise false
	 */
	@Override
	public boolean companyExists(String companyName) {
		int count = entityManager.createNamedQuery("company.findByCompanyName").
				setParameter("companyName", companyName)
				.getResultList().size();
		return count > 0 ? true : false;
	}

}
