package com.firok.springer.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firok.springer.dao.IBaseDao;
import com.firok.springer.dao.ICustomerDao;
import com.firok.springer.entities.Customer;
import com.firok.springer.services.ICustomerService;

@Service
public class CustomerService extends BaseService<Customer, Long> implements ICustomerService {

	@Autowired
	private ICustomerDao customerDao;

	@Override
	protected IBaseDao<Customer, Long> getDao() {
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
