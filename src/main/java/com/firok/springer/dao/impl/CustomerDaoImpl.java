package com.firok.springer.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.firok.springer.dao.CustomerDao;
import com.firok.springer.entity.Customer;

@Transactional
@Repository
public class CustomerDaoImpl extends BaseDaoImpl<Customer , Long> implements CustomerDao {
	
	
	public CustomerDaoImpl() {
		super(Customer.class);
	}

	@Override
	public boolean customerExists(String username, String email) {
		int count = entityManager.createNamedQuery("customer.findByUsernameOrEmail").setParameter("username", username)
				.setParameter("email", email).getResultList().size();
		return count > 0 ? true : false;
	}

	
}
