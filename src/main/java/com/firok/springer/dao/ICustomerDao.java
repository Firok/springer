package com.firok.springer.dao;

import com.firok.springer.entities.Customer;

public interface ICustomerDao extends IBaseDao<Customer, Long> {

	boolean customerExists(String username, String email);
}
