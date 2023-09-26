package com.hm.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.hm.dto.CustomerDTO;

import com.hm.entity.Customer;
import com.hm.repository.CustomerRepository;

@Component
public class CustomerConverter {

	@Autowired
	 CustomerRepository customerRepo;
	
	public Customer convertCrDtoToEntity(CustomerDTO cDto) {
		Customer c=new Customer();
		if(cDto!=null) {
			BeanUtils.copyProperties(cDto, c);
		}
		return c;
		
	}
//	method to convert customer entity to  dto
	public CustomerDTO convertBkEntityToDto(Customer c) {
		CustomerDTO cDto=new CustomerDTO();
		if(c!=null) {
			BeanUtils.copyProperties(c, cDto);
		}
		return cDto;
	}
	
}
