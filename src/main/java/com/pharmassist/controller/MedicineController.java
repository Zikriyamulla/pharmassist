package com.pharmassist.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pharmassist.service.MedicineService;
import com.pharmassist.util.AppResponseBuilder;
import com.pharmassist.util.SimpleResponseStructure;

@RestController
public class MedicineController {
	private final MedicineService medicineService;
	private final AppResponseBuilder responseBuilder;
	public MedicineController(MedicineService medicineService, AppResponseBuilder responseBuilder) {
		super();
		this.medicineService = medicineService;
		this.responseBuilder = responseBuilder;
	}
	@PostMapping("/pharmacy/{pharmacyId}/medicines")
	public ResponseEntity<SimpleResponseStructure> uploadMedicines(@RequestParam MultipartFile file,@PathVariable String pharmacyId){
		String medicines =medicineService.uploadMedicines(file,pharmacyId);
		return responseBuilder.success(HttpStatus.CREATED,medicines);
		
	}
	

}
