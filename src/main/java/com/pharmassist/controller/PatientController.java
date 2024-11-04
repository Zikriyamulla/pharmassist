package com.pharmassist.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pharmassist.requestdtos.PatientRequest;
import com.pharmassist.responsedtos.PatientResponse;
import com.pharmassist.service.PatientService;
import com.pharmassist.util.AppResponseBuilder;
import com.pharmassist.util.ResponseStructure;

@RestController
public class PatientController {
	private final PatientService patientService;
	private final AppResponseBuilder responseBuilder;
	public PatientController(PatientService patientService, AppResponseBuilder responseBuilder) {
		super();
		this.patientService = patientService;
		this.responseBuilder = responseBuilder;
	}
	
	public ResponseEntity<ResponseStructure<PatientResponse>> savePatient(@RequestBody PatientRequest patientRequest){
		PatientResponse response=patientService.savePatient(patientRequest);
		return responseBuilder.success(HttpStatus.CREATED, "Patient Created", response);
		
	}

}
