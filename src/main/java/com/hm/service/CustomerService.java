package com.hm.service;

import java.util.List;

import com.hm.dto.CustomerDTO;
import com.hm.entity.Customer;
import com.hm.exception.ResourceNotFoundException;

public interface CustomerService {
 
//	method to create customer
	public CustomerDTO createCustomer(Customer c);
	
//	method to get all customer
	
	List<CustomerDTO>getAllCustomer();
	
//	method to get customer by id
	
	CustomerDTO getCustomerById(int cId) throws ResourceNotFoundException;
	
//	method to update customer by id
	
	CustomerDTO updateCustomer(int cId,Customer c) throws ResourceNotFoundException;
	
//	method to customer by delete
	
	void customerDeleteById(int cId);

	
//	Customer login
	
	Customer login(String customerName,String password);

}
