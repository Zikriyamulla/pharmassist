package com.pharmassist.service;

import com.pharmassist.repository.MedicineRepository;

public class MedicineService {
	private final MedicineRepository medicineRepository ;

	public MedicineService(MedicineRepository medicineRepository) {
		super();
		this.medicineRepository = medicineRepository;
	}
	

}
