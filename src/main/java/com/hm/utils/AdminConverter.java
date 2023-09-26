package com.hm.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hm.dto.AdminDTO;
import com.hm.entity.Admin;
import com.hm.repository.AdminRepository;

@Component
public class AdminConverter {
	@Autowired
	 AdminRepository adminRepo;
	
	public Admin convertAdDtoToEntity(AdminDTO aDto) {
		Admin a=new Admin();
		if(aDto!=null) {
			BeanUtils.copyProperties(aDto, a);
		}
		return a;
		
	}
//	method to convert admin entity to  dto
	
	public AdminDTO convertAdEntityToDto(Admin a) {
		AdminDTO aDto=new AdminDTO();
		if(a!=null) {
			BeanUtils.copyProperties(a, aDto);
		}
		return aDto;
	}
	
}
