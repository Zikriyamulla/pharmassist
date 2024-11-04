package com.pharmassist.service;

import org.springframework.stereotype.Service;

import com.pharmassist.mapper.PatientMapper;
import com.pharmassist.repository.PatientRepository;
import com.pharmassist.requestdtos.PatientRequest;
import com.pharmassist.responsedtos.PatientResponse;
import com.pharmassist.util.AppResponseBuilder;

@Service
public class PatientService {
	private final PatientRepository patientRepository;
	private final PatientMapper patientMapper;
	public PatientService(PatientRepository patientRepository, PatientMapper patientMapper) {
		super();
		this.patientRepository = patientRepository;
		this.patientMapper = patientMapper;
	}
	public PatientResponse savePatient(PatientRequest patientRequest) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
