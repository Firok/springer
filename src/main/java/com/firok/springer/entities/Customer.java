package com.firok.springer.entities;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({
	@NamedQuery(name="customer.findByUsernameOrEmail", query="SELECT c FROM Customer c WHERE c.username=:username OR c.email=:email")
})
public class Customer extends User {
	
	private static final long serialVersionUID  = 1L;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String username, String password, String email) {
		super(username, password, email);
		// TODO Auto-generated constructor stub
	}
	
	

	
}
