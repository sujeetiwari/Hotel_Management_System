package com.hm.controller;

import java.util.List;

import javax.servlet.ServletException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.hm.dto.CustomerDTO;
import com.hm.entity.Customer;
import com.hm.service.CustomerService;
import com.hm.utils.CustomerConverter;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerService cusService;
	

	
	@Autowired
	CustomerConverter cusConvert;
	
	@PostMapping("/saveCustomer")
	public CustomerDTO createBooking(@Valid @RequestBody CustomerDTO cDto) {	
	final Customer c = cusConvert.convertCrDtoToEntity(cDto);
		return cusService.createCustomer(c);
	}
	
	@GetMapping("/getAllCustomer")
	public List<CustomerDTO>getAllCustomer() {
		return cusService.getAllCustomer();
	}
	
	@GetMapping("/getCustomerById/{id}")
	 CustomerDTO getCustomerById(@PathVariable("id") int cId) {
		return cusService.getCustomerById(cId);
	}
	
	@PutMapping("/updateCustomerById/{cId}")
	CustomerDTO updateCustomerById(@PathVariable("cId") int id ,CustomerDTO cDto) {
		final Customer c=cusConvert.convertCrDtoToEntity(cDto);
		return cusService.updateCustomer(id, c);
	}
	
	@DeleteMapping("/deleteCustomerById/{cId}")
	 public ResponseEntity<String> deleteCustomerById(@PathVariable("cId") int id){
		cusService.customerDeleteById(id);
		return new ResponseEntity<String> ("Customer with id"+id+" deleted success ", HttpStatus.OK );
	}
	
	@PostMapping("/loginCustomer/{customer}/{pass}")
	public void login(@PathVariable("customer") String customerName, @PathVariable("pass") String password) throws ServletException{
		if(customerName.isBlank() || password.isBlank())
		{
			throw new ServletException("Please fill in customerName and password");
			}
		Customer c=cusService.login(customerName, password);
		}
	

}
