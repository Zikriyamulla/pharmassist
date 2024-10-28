package com.pharmassist.service;

import org.springframework.stereotype.Service;

import com.pharmassist.repository.AdminRepository;
import com.pharmassist.requestdtos.AdminRequest;
import com.pharmassist.responsedtos.AdminResponse;

import jakarta.validation.Valid;

@Service
public class AdminService {
	private final AdminRepository adminRepository;

	public AdminService(AdminRepository adminRepository) {
		super();
		this.adminRepository = adminRepository;
	}

	
	

}
