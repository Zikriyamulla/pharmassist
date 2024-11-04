package com.pharmassist.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.pharmassist.entity.Patient;
import com.pharmassist.exception.PharmacyNotFoundByIdException;
import com.pharmassist.mapper.PatientMapper;
import com.pharmassist.repository.PatientRepository;
import com.pharmassist.repository.PharmacyRepository;
import com.pharmassist.requestdtos.PatientRequest;
import com.pharmassist.responsedtos.PatientResponse;


@Service
public class PatientService {
	private final PatientRepository patientRepository;
	private final PharmacyRepository pharmacyRepository;
	private final PatientMapper patientMapper;
	public PatientService(PatientRepository patientRepository, PatientMapper patientMapper, PharmacyRepository pharmacyRepository) {
		super();
		this.patientRepository = patientRepository;
		this.pharmacyRepository = pharmacyRepository;
		this.patientMapper = patientMapper;
	}
	public PatientResponse savePatient(PatientRequest patientRequest,String pharmacyId) {
		
		return pharmacyRepository.findById(pharmacyId).map((pharmacy)->{
			Patient patient = patientMapper.mapToPatient(patientRequest, new Patient());
			patient.setPharmacy(pharmacy);
			
			if(pharmacy.getPatients()==null)
				pharmacy.setPatients(new ArrayList());
			
			pharmacy.getPatients().add(patient);
			patient = patientRepository.save(patient);
			return patientMapper.mapToPatientResponse(patient);
		}).orElseThrow(()-> new PharmacyNotFoundByIdException("Failed to add patients due to No Pharmacy Found with id: "+pharmacyId));
	}
	
	

}
