package com.pharmassist.controller;


import org.springframework.web.bind.annotation.RestControllerAdvice;


import com.pharmassist.service.PharmacyService;
import com.pharmassist.util.AppResponseBuilder;


@RestControllerAdvice
public class PharmacyController {
	private final PharmacyService pharmacyService;
	private final AppResponseBuilder responseBuilder;
	public PharmacyController(PharmacyService pharmacyService, AppResponseBuilder responseBuilder) {
		super();
		this.pharmacyService = pharmacyService;
		this.responseBuilder = responseBuilder;
	}
	
}
