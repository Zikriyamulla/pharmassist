package com.pharmassist.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

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
	
	@PostMapping("/pharmacy/{adminId}")
	public ResponseEntity<ResponseStructure<PharmacyResponse>> savePharmacy(@RequestBody @Valid PharmacyRequest pharmacyRequest, @PathVariable String adminId){
		PharmacyResponse response=pharmacyService.savePharmacy(pharmacyRequest,adminId);
		return responseBuilder.success(HttpStatus.CREATED, "Pharmacy created", response);
		
	}
	
}
