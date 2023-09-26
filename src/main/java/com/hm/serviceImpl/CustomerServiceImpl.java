package com.hm.serviceImpl;




import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hm.dto.CustomerDTO;
import com.hm.entity.Customer;
import com.hm.exception.ResourceNotFoundException;
import com.hm.repository.BookingRepository;
import com.hm.repository.CustomerRepository;
import com.hm.service.CustomerService;
import com.hm.utils.CustomerConverter;

import lombok.extern.slf4j.Slf4j;



@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService{

//	logger created
	private static final Logger log=LoggerFactory.getLogger(Customer.class);

	@Autowired
	CustomerConverter customerConvert;
	
	@Autowired
	CustomerRepository cusRepo;
	
	@Autowired
	BookingRepository bookRepo;
	
	@Override
	public CustomerDTO createCustomer(Customer c) {
		String pass=c.getCustomerName().substring(0,3).toLowerCase()+"123";
		c.setPassword(pass);
				cusRepo.save(c);
				log.info("New student details "+ c.toString() + "saved at" +new Date());

		return customerConvert.convertBkEntityToDto(c);
	}

	@Override
	public List<CustomerDTO> getAllCustomer() {
		List<Customer>c=cusRepo.findAll();
		List<CustomerDTO>cDto=new ArrayList<>();
		for(Customer cus:c) {
			cDto.add(customerConvert.convertBkEntityToDto(cus));
			
		}
		log.info("All Customer details fetched at "+new Date());

		return cDto;
	}

	@Override
	public CustomerDTO getCustomerById(int cId) throws ResourceNotFoundException {
		Customer c=cusRepo.findById(cId).orElseThrow(()-> new ResourceNotFoundException("Customer","id",cId));
		return customerConvert.convertBkEntityToDto(c);
	}

	@Override
	public CustomerDTO updateCustomer(int cId, Customer c) throws ResourceNotFoundException {
	Customer customer=cusRepo.findById(cId).orElseThrow(()-> new ResourceNotFoundException("Customer", "id", cId));
	customer.setAddress(c.getAddress());
	customer.setContact(c.getContact());
	customer.setGender(c.getGender());
	customer.setPassword(c.getPassword());
	cusRepo.save(customer);
	
		return customerConvert.convertBkEntityToDto(c);
	}

	@Override
	public void customerDeleteById(int cId) {
		Customer c=cusRepo.findById(cId).orElseThrow(()-> new ResourceNotFoundException("Customer", "id", cId));
		 cusRepo.deleteById(cId);
		
	}

	@Override
	public Customer login(String customerName, String password) {
		
		return cusRepo.findByCustomerNameAndPassword(customerName, password);
	}

	
}
