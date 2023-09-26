package com.hm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hm.entity.Admin;



public interface AdminRepository  extends JpaRepository<Admin, Integer>{
	

	Admin findByAdminNameAndPassword(String adminName,String password);
}
