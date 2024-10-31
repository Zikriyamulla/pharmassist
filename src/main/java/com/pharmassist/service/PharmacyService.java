package com.pharmassist.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pharmassist.entity.Pharmacy;
import com.pharmassist.exception.AdminNotFoundException;
import com.pharmassist.exception.PharmacyNotFoundException;
import com.pharmassist.mapper.PharmacyMapper;
import com.pharmassist.repository.AdminRepository;
import com.pharmassist.repository.PharmacyRepository;
import com.pharmassist.requestdtos.PharmacyRequest;
import com.pharmassist.responsedtos.PharmacyResponse;

@Service
public class PharmacyService {
	private final PharmacyRepository pharmacyRepository;
	private final AdminRepository adminRepository;
	private final PharmacyMapper pharmacyMapper;
	public PharmacyService(PharmacyRepository pharmacyRepository, PharmacyMapper pharmacyMapper, AdminRepository adminRepository) {
		super();
		this.pharmacyRepository = pharmacyRepository;
		this.adminRepository = adminRepository;
		this.pharmacyMapper = pharmacyMapper;
	}
	public PharmacyResponse savePharmacy(PharmacyRequest pharmcyRequest, String adminId) {
		return adminRepository.findById(adminId)
		.map((admin)->{
			 Pharmacy pharmacy=pharmacyRepository.save(pharmacyMapper.mapToPharmacy(pharmcyRequest, new Pharmacy()));
			 admin.setPharmacy(pharmacy);
			 adminRepository.save(admin);
			 return pharmacy;	 
		})
		.map(pharmacyMapper::mapToPharmacyResponse).orElseThrow(()->new AdminNotFoundException(adminId));
	}
	public PharmacyResponse findPharmacyById(String pharmacyId) {
		return pharmacyRepository.findById(pharmacyId) 
		.map(pharmacyMapper::mapToPharmacyResponse).orElseThrow(()-> new PharmacyNotFoundException("Failed to find pharmacy"));
	}
	public List<PharmacyResponse> findAllPharmacy() {
		return pharmacyRepository.findAll().stream().map(pharmacyMapper::mapToPharmacyResponse).toList();
	}
	
	
	

}
