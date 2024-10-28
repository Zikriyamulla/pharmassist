package com.pharmassist.service;

import org.springframework.stereotype.Service;

import com.pharmassist.entity.Admin;
import com.pharmassist.mapper.AdminMapper;
import com.pharmassist.repository.AdminRepository;
import com.pharmassist.requestdtos.AdminRequest;
import com.pharmassist.responsedtos.AdminResponse;



@Service
public class AdminService {
	private final AdminRepository adminRepository;
	private final AdminMapper adminMapper;

	public AdminService(AdminRepository adminRepository,AdminMapper adminMapper) {
		super();
		this.adminRepository = adminRepository;
		this.adminMapper = adminMapper;
	}

	public  AdminResponse saveAdmin( AdminRequest adminRequest) {
		Admin admin=adminRepository.save(adminMapper.mapToAdmin(adminRequest, new Admin()));
		return adminMapper.mapToAdminResponse(admin);
		
		
	}

	
	

}
