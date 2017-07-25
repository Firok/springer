package com.firok.springer;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.firok.springer.entity.Customer;
import com.firok.springer.services.CustomerService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringerApplicationTests {

	@Autowired
	CustomerService customerService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testCustomerExists(){
		boolean flag = customerService.addCustomer(new Customer("firok", "test", "firok@gmail.com"));
		
		assertEquals(true, flag);
	}

}
