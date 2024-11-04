package com.pharmassist.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pharmassist.requestdtos.PatientRequest;
import com.pharmassist.responsedtos.PatientResponse;
import com.pharmassist.service.PatientService;
import com.pharmassist.util.AppResponseBuilder;
import com.pharmassist.util.ResponseStructure;

import jakarta.validation.Valid;

@RestController
public class PatientController {
	private final PatientService patientService;
	private final AppResponseBuilder responseBuilder;
	public PatientController(PatientService patientService, AppResponseBuilder responseBuilder) {
		super();
		this.patientService = patientService;
		this.responseBuilder = responseBuilder;
	}
	@PostMapping("/pharmacy/{pharmacyId}/patients")
	public ResponseEntity<ResponseStructure<PatientResponse>> savePatient(@RequestBody @Valid PatientRequest patientRequest,@PathVariable String pharmacyId){
		PatientResponse response=patientService.savePatient(patientRequest,pharmacyId);
		return responseBuilder.success(HttpStatus.CREATED, "Patient Created", response);
		
	}

}
