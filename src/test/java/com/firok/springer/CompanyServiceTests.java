package com.firok.springer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.firok.springer.entity.Company;
import com.firok.springer.services.CompanyService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyServiceTests {

	@Autowired
	CompanyService companyService;

	/**
	 * Automated test for adding a new company
	 */
	@Test
	public void testaddCompany(){
		Company company = new Company("Smaato", "Smaato is a global real-time advertising platform for mobile publishers and app developers, with a strong focus on helping these parties monetize their mobile apps and websites", "https://www.smaato.com");
		
		boolean flag = companyService.addCompany(company);
		
		assertEquals(true, flag);
	}
	
	/**
	 * Automated test for getting list of companies
	 */
	@Test
	public void testGetAllCompanies(){
		List<Company> companies=new ArrayList<>();
		
		companies = companyService.findAll();
		
		assertNotNull(companies);;
	}
	
	/**
	 * Automated test for finding a company by id
	 */
	@Test
	public void testFindCompany(){
		Company company =companyService.find(1L);
		
		assertNotNull(company);;
	}

}
