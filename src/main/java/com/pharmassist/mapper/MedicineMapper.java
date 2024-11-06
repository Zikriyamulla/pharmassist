package com.pharmassist.mapper;

import com.pharmassist.entity.Medicine;
import com.pharmassist.requestdtos.MedicineRequest;
import com.pharmassist.responsedtos.MedicineResponse;

public class MedicineMapper {
	
	public Medicine mapToMedicine(MedicineRequest request, Medicine medicine) {
		medicine.setName(request.getName());
		medicine.setCategory(request.getCategory());
		medicine.setIngredients(request.getIngredients());
		medicine.setDossageInMg(request.getDossageInMg());
		medicine.setForms(request.getForms());
		medicine.setStockQuantity(request.getStockQuantity());
		medicine.setManufacture(request.getManufacture());
		medicine.setExpireDate(request.getExpireDate());
		medicine.setPrice(request.getPrice());
		return medicine;
		
	}
	
	public MedicineResponse mapToMedicineResponse(Medicine medicine) {
		MedicineResponse response = new MedicineResponse();
		response.setMedicineId(medicine.getMedicineId());
		response.setName(medicine.getName());
		response.setCategory(medicine.getCategory());
		response.setIngredients(medicine.getIngredients());
		response.setDossageInMg(medicine.getDossageInMg());
		response.setForms(medicine.getForms());
		response.setStockQuantity(medicine.getStockQuantity());
		response.setManufacture(medicine.getManufacture());
		response.setExpireDate(medicine.getExpireDate());
		response.setPrice(medicine.getPrice());
		return response;
	}

}
