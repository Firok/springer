package com.firok.springer.dao;

import com.firok.springer.entity.Customer;

public interface CustomerDao extends BaseDao<Customer, Long> {

	boolean customerExists(String username, String email);
}
