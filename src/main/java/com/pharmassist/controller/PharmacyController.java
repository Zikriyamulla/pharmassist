package com.pharmassist.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.pharmassist.requestdtos.PharmacyRequest;
import com.pharmassist.responsedtos.PharmacyResponse;
import com.pharmassist.service.PharmacyService;
import com.pharmassist.util.AppResponseBuilder;
import com.pharmassist.util.ResponseStructure;

import jakarta.validation.Valid;



@RestController
public class PharmacyController {
	private final PharmacyService pharmacyService;
	private final AppResponseBuilder responseBuilder;
	public PharmacyController(PharmacyService pharmacyService, AppResponseBuilder responseBuilder) {
		super();
		this.pharmacyService = pharmacyService;
		this.responseBuilder = responseBuilder;
	}
	
	@PostMapping("/admins/{adminId}/pharmacy")
	public ResponseEntity<ResponseStructure<PharmacyResponse>> savePharmacy(@RequestBody @Valid PharmacyRequest pharmacyRequest, @PathVariable String adminId){
		PharmacyResponse response=pharmacyService.savePharmacy(pharmacyRequest,adminId);
		return responseBuilder.success(HttpStatus.CREATED, "Pharmacy created", response);
		
	}
	@GetMapping("/admins/{adminId}/pharmacy")
	public ResponseEntity<ResponseStructure<PharmacyResponse>> findPharmacy(@PathVariable String adminId){
	PharmacyResponse response=pharmacyService.findPharmacy(adminId);
	return responseBuilder.success(HttpStatus.FOUND, "Pharmacy founded", response);
		
	}
	
	@GetMapping("/allPharmacy")
	public ResponseEntity<ResponseStructure<List<PharmacyResponse>>> findAllPharmacy(){
	List<PharmacyResponse> response=pharmacyService.findAllPharmacy();
	return  responseBuilder.success(HttpStatus.FOUND, "Pharmacy founded", response);
	}
	@PutMapping("/pharmacy/{pharmacyId}")
	public ResponseEntity<ResponseStructure<PharmacyResponse>> updatePharmacyById(@RequestBody PharmacyRequest pharmacyRequest, @PathVariable String pharmacyId){
	PharmacyResponse response=pharmacyService.updatePharmacyById(pharmacyRequest,pharmacyId);
	return responseBuilder.success(HttpStatus.OK, "Pharmacy updated", response);
		
	}
	
	
	
	
	
	
	
	
	
	
}
