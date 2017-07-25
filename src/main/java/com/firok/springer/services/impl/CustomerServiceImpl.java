package com.firok.springer.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firok.springer.dao.BaseDao;
import com.firok.springer.dao.CustomerDao;
import com.firok.springer.entity.Customer;
import com.firok.springer.services.CustomerService;

@Service
public class CustomerServiceImpl extends BaseServiceImpl<Customer, Long> implements CustomerService {

	@Autowired
	private CustomerDao customerDao;

	@Override
	protected BaseDao<Customer, Long> getDao() {
		return customerDao;
	}

	@Override
	public synchronized boolean addCustomer(Customer customer) {
		if(customerDao.customerExists(customer.getUsername(), customer.getEmail())){
			return false;
		}
		else {
			customerDao.create(customer);
			return true;
		}
	}
}
