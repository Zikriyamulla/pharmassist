package com.pharmassist.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pharmassist.entity.Admin;
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

	public List<PharmacyResponse> findAllPharmacy() {
		return pharmacyRepository.findAll().stream().map(pharmacyMapper::mapToPharmacyResponse).toList();
	}
	
	
	
	
	
	public PharmacyResponse findPharmacyById(String adminId) {
	
		
				 return adminRepository.findById(adminId)
					        .map(admin -> {
					            Pharmacy pharmacy = admin.getPharmacy();
					            return pharmacy != null 
					                ? pharmacyMapper.mapToPharmacyResponse(pharmacy) 
					                :throwPharmacyNoFound();
					        })
					        .orElseThrow(() -> new PharmacyNotFoundException("No pharmacy found due to admin not present"));
		
	}
	public static PharmacyResponse throwPharmacyNoFound() {
		throw new PharmacyNotFoundException("No pharmacy found due to admin not having an associated pharmacy");
	}
	public PharmacyResponse updatePharmacyById(PharmacyRequest pharmacyRequest, String pharmacyId) {
		return pharmacyRepository.findById(pharmacyId).map(exPharmacy->{
			pharmacyMapper.mapToPharmacy(pharmacyRequest,exPharmacy);
			return pharmacyRepository.save(exPharmacy);
		}).map(pharmacyMapper::mapToPharmacyResponse).orElseThrow(()-> new PharmacyNotFoundException("Failed to update the pharmacy"));
	}
	
	
	
	

}
