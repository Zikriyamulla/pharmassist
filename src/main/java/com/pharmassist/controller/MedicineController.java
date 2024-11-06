package com.pharmassist.controller;

import org.springframework.web.bind.annotation.RestController;

import com.pharmassist.service.MedicineService;
import com.pharmassist.util.AppResponseBuilder;

@RestController
public class MedicineController {
	private final MedicineService medicineService;
	private final AppResponseBuilder responseBuilder;
	public MedicineController(MedicineService medicineService, AppResponseBuilder responseBuilder) {
		super();
		this.medicineService = medicineService;
		this.responseBuilder = responseBuilder;
	}
	
	

}
