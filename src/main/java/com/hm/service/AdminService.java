package com.hm.service;

import java.util.List;

import com.hm.dto.AdminDTO;
import com.hm.entity.Admin;
import com.hm.exception.ResourceNotFoundException;

public interface AdminService {

	
//	method to create admin
	public AdminDTO saveAdminDetail(Admin a) ;
	
//	method to get all admin
	
	List<AdminDTO>getAllAdmin();
	
//	method to get admin by id
	
	AdminDTO getAdminById(int aId) throws ResourceNotFoundException;
	
//	method to update admin by id
	
	AdminDTO updateAdmin(int aId,Admin a) throws ResourceNotFoundException;
	
//	method to admin by delete
	
	void AdminDeleteById(int aId);
	
	
//	Admin login
	
	Admin login(String adminName,String password);
	
	
}
