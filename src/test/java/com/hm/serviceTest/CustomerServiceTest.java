package com.hm.serviceTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.hm.dto.CustomerDTO;
import com.hm.entity.Customer;
import com.hm.repository.CustomerRepository;
import com.hm.service.CustomerService;
import com.hm.utils.CustomerConverter;

@SpringBootTest
public class CustomerServiceTest {
	
	@Autowired
	CustomerConverter customerConverter;
	
	@Autowired
	CustomerService customService;
	
	@MockBean
	CustomerRepository customerRepository;
	
	@Test
	@DisplayName("Positive Test Case")
	void testMethod() {
		Customer c=Customer.builder().customerName("Saurav").email("saurav@gmail.com").address("Delhi").gender("Male").build();
		Mockito.when(customerRepository.save(c)).thenReturn(c);
		CustomerDTO cDto=customerConverter.convertBkEntityToDto(c);
//		assertTrue(customService.createCustomer(c).getCustomerName().equals("Saurav"));	
		assertEquals(cDto.getCustomerName(), customService.createCustomer(c).getCustomerName());
	}
	
	@Test
	@DisplayName(" Test Case By Id")
	void testMethodById() {
		Customer c=Customer.builder().customerName("Saurav").email("saurav@gmail.com").address("Delhi").gender("Male").build();
		Mockito.when(customerRepository.findById(c.getCustomerId())).thenReturn(Optional.of(c));
		
		assertThat(customService.getCustomerById(c.getCustomerId()).getEmail()).isEqualTo("saurav@gmail.com");
	}
	
	
	@Test
	@DisplayName("Negative Test Case")
	void testMethod1() {
		Customer c=Customer.builder().customerName("Saurav").email("saurav@gmail.com").address("Delhi").gender("Male").build();
		Mockito.when(customerRepository.save(c)).thenReturn(c);
		assertTrue(customService.createCustomer(c).getEmail().equals("saurav123@gmail.com"));		
	}

}
