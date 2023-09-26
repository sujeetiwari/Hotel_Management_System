package com.hm.serviceTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.hm.dto.AdminDTO;
import com.hm.entity.Admin;
import com.hm.repository.AdminRepository;
import com.hm.service.AdminService;
import com.hm.utils.AdminConverter;

@SpringBootTest
public class AdminServiceTest {
	
	@Autowired
	AdminService adminService;
	
	@Autowired
	AdminConverter adminConverter;
	
	@MockBean
	AdminRepository adminRepository;
	
	@Test
	@DisplayName("Positive Test Case")
	void TestSaveHotel(){
		
		Admin a=Admin.builder().email("sujeetiwari@gmail.com").build();
		Mockito.when(adminRepository.save(a)).thenReturn(a);
		
		AdminDTO aDTo=adminConverter.convertAdEntityToDto(a);
		
		assertTrue(adminService.saveAdminDetail(a).getEmail().equals("sujeetiwari@gmail.com"));
	}
	
	@Test
	@DisplayName("Test Case By Id")
      void testGetAdminById(){
		
		Admin a=Admin.builder().email("sujeetiwari@gmail.com").build();
		Mockito.when(adminRepository.findById(a.getId())).thenReturn(Optional.of(a));
				
		assertThat(adminService.getAdminById(a.getId()).getEmail()).isEqualTo("sujeetiwari@gmail.com");
	}
	
	@Test
	@DisplayName("Negative Test Case")
	void negativeTestSaveHotel(){
		
		Admin a=Admin.builder().email("ayushthakur@gmail.com").adminName("ayushthakur").build();
		Mockito.when(adminRepository.save(a)).thenReturn(a);
		
		
		assertTrue(adminService.saveAdminDetail(a).getAdminName().equals("ayushthakur123"));
	}

}
