package com.test.springbootdrools.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.springbootdrools.model.Customer;
import com.test.springbootdrools.service.CustomerService;
/**
 * http://localhost:8080/getDiscount?name=Frank&numyears=5
 * 
 * @author tptan
 *
 */
@RestController
public class CustomerController {

	@Autowired
	private CustomerService service;

	@RequestMapping(value = "/getDiscount", method = RequestMethod.GET, produces = "application/json")
	public Customer getCustomerDiscount(
			@RequestParam(required = true) String name,
			@RequestParam(required = true) Integer numyears) {
		
		Customer customer = new Customer(name);
		customer.setAge(numyears);
		
		service.insertCustomer(customer);
		
		return customer;
		
	}
	
	
	
	

}
