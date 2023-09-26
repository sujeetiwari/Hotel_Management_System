package com.hm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hm.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

//    login customer with name and password
	Customer findByCustomerNameAndPassword(String customerName,String password);


   
}
