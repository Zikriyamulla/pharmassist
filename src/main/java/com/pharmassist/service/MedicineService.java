package com.pharmassist.service;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.pharmassist.entity.Medicine;
import com.pharmassist.entity.Pharmacy;
import com.pharmassist.enums.Forms;
import com.pharmassist.exception.PharmacyNotFoundByIdException;
import com.pharmassist.mapper.MedicineMapper;
import com.pharmassist.repository.MedicineRepository;
import com.pharmassist.repository.PharmacyRepository;
import com.pharmassist.responsedtos.MedicineResponse;

@Service
public class MedicineService {
	private final MedicineRepository medicineRepository ;
	private final PharmacyRepository pharmacyRepository;
	private final MedicineMapper medicineMapper;


	public MedicineService(MedicineRepository medicineRepository, PharmacyRepository pharmacyRepository, MedicineMapper medicineMapper) {
		super();
		this.medicineRepository = medicineRepository;
		this.pharmacyRepository = pharmacyRepository;
		this.medicineMapper = medicineMapper;
	}

	public String uploadMedicines(MultipartFile file,String pharmacyId) {
		List<Medicine> medicines = new ArrayList<>();

		Pharmacy pharmacy = pharmacyRepository.findById(pharmacyId)
				.orElseThrow(()->new PharmacyNotFoundByIdException("Failed to upload due to no Pharmacy found by Id "+pharmacyId));

		try (XSSFWorkbook workBook= new XSSFWorkbook(file.getInputStream())){

			for(Sheet sheet : workBook) {
				for(Row row : sheet) {
					if(row.getRowNum() != 0) {
						Medicine medicine = new Medicine();
						medicine.setName(row.getCell(0).getStringCellValue());
						medicine.setCategory(row.getCell(1).getStringCellValue());
						medicine.setDossageInMg((int) row.getCell(2).getNumericCellValue());

						String formValue = row.getCell(3).getStringCellValue();
						medicine.setForms(Forms.valueOf(formValue.toUpperCase()));

						medicine.setIngredients(row.getCell(4).getStringCellValue());

						medicine.setManufacture(row.getCell(5).getStringCellValue());
						medicine.setStockQuantity(10);
						medicine.setPrice(row.getCell(6).getNumericCellValue());

						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
						medicine.setExpireDate(LocalDate.parse(row.getCell(7).getStringCellValue(), formatter));



						medicine.setPharmacy(pharmacy);

						medicines.add(medicine);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		medicineRepository.saveAll(medicines);
		return "Uploaded " + medicines.size() + " medicines successfully!";

	}

	public List<MedicineResponse> findMedicineByNameOrIngredient(String input) {
		List<Medicine> medicines = medicineRepository.findMedicineByNameOrIngredient(input);
		if(medicines.isEmpty()) {
			throw null;
		}
		return medicines.stream()
				.map(medicineMapper:: mapToMedicineResponse)
				.toList();
	}



}
