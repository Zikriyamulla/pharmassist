package com.pharmassist.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pharmassist.entity.Admin;
import com.pharmassist.exception.AdminNotFoundException;
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

	public AdminResponse findAdminById(String adminId) {
		
		return adminRepository.findById(adminId)
				.map(adminMapper::mapToAdminResponse).orElseThrow(() ->new AdminNotFoundException("Failed to found"));
	}

	

	

	public AdminResponse updateAdmin(AdminRequest adminRequest,String adminId) {
		return adminRepository.findById(adminId).map(exAdmin ->{
			adminMapper.mapToAdmin(adminRequest, exAdmin);
			return adminRepository.save(exAdmin);
		}).map(adminMapper::mapToAdminResponse).orElseThrow(()->new AdminNotFoundException("Failed to update"));
	}

	public List<AdminResponse> findAllAdmins() {
		return adminRepository.findAll().stream().map(adminMapper::mapToAdminResponse).toList();
		
	}

	
	

}
