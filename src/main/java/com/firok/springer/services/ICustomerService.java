package com.firok.springer.services;

import com.firok.springer.entities.Customer;

public interface ICustomerService extends IBaseService<Customer, Long> {

	boolean addCustomer(Customer customer);
	
}
