package com.hm.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hm.dto.AdminDTO;
import com.hm.entity.Admin;
import com.hm.exception.ResourceNotFoundException;
import com.hm.repository.AdminRepository;
import com.hm.service.AdminService;
import com.hm.utils.AdminConverter;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AdminServiceImpl implements AdminService {
	
//	logger created
	private static final Logger log=LoggerFactory.getLogger(Admin.class);


	@Autowired
	AdminRepository adminRepo;
	
	@Autowired
	AdminConverter adminConvert;

	@Override
	public AdminDTO saveAdminDetail(Admin a) {
		int end=a.getEmail().indexOf("@");
		String admin=a.getEmail().substring(0, end);
		a.setAdminName(admin);
		
		String pass=a.getAdminName().substring(0,3).toLowerCase()+"123";
		a.setPassword(pass);
				adminRepo.save(a);
				log.info(" New Admin details "+ a.toString() + "saved at" + new Date());
		return adminConvert.convertAdEntityToDto(a);
		
	}

	@Override
	public List<AdminDTO> getAllAdmin() {
		List<Admin>a=adminRepo.findAll();
		List<AdminDTO>aDto=new ArrayList<>();
		for(Admin ad:a) {
			aDto.add(adminConvert.convertAdEntityToDto(ad));
			
		}
		log.info("All Admin details fetched at " +new Date());

		return aDto;
		
	}

	@Override
	public AdminDTO getAdminById(int aId) throws ResourceNotFoundException {
		Admin a=adminRepo.findById(aId).orElseThrow(()-> new ResourceNotFoundException("Admin","id",aId));
		return adminConvert.convertAdEntityToDto(a);

	
	}

	@Override
	public AdminDTO updateAdmin(int aId, Admin a) throws ResourceNotFoundException {
		Admin admin=adminRepo.findById(aId).orElseThrow(()-> new ResourceNotFoundException("Admin", "id", aId));
		admin.setAdminName(a.getAdminName());
		admin.setPassword(a.getPassword());
		adminRepo.save(admin);
		
			return adminConvert.convertAdEntityToDto(a);
	}

	@Override
	public void AdminDeleteById(int aId) {
		Admin a=adminRepo.findById(aId).orElseThrow(()-> new ResourceNotFoundException("Admin", "id", aId));
		 adminRepo.deleteById(aId);
	}

	@Override
	public Admin login(String adminName, String password) {
		
		return adminRepo.findByAdminNameAndPassword(adminName, password);
	}
	
	


}
