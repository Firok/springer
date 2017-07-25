package com.firok.springer.services;

import com.firok.springer.entity.Customer;

public interface CustomerService extends BaseService<Customer, Long> {

	boolean addCustomer(Customer customer);
	
}
