package com.pharmassist.mapper;

import com.pharmassist.entity.Patient;

import com.pharmassist.requestdtos.PatientRequest;

import com.pharmassist.responsedtos.PatientResponse;


public class PatientMapper {
	public Patient mapToPatient(PatientRequest request, Patient patient) {
		patient.setName(request.getName());
		patient.setPhoneNumber(request.getPhoneNumber());
		patient.setEmail(request.getEmail());
		patient.setGender(request.getGender());
		patient.setDateOfBirth(request.getDateOfBirth());
		return patient;
	}
	public PatientResponse mapToPatientResponse(Patient patient) {
		PatientResponse response = new PatientResponse();
		response.setPatientId(patient.getPatientId());
		response.setName(patient.getName());
		response.setEmail(patient.getEmail());
		response.setGender(patient.getGender());
		
		
		return response;
		
	}

}
