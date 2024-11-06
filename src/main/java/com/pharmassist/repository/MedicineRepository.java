package com.pharmassist.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pharmassist.entity.Medicine;
import com.pharmassist.entity.Pharmacy;

public interface MedicineRepository extends JpaRepository<Medicine, String>{
	 @Query("SELECT m FROM Medicine m WHERE m.pharmacy.pharmacyId = :pharmacyId AND m.name = :name")
	   public  Optional<Medicine> findByPharmacyIdAndName(@Param("pharmacyId") String pharmacyId, @Param("name") String name);
	 
	@Query("SELECT m FROM Medicine m WHERE m.pharmacy.pharmacyId = :pharmacyId AND m.medicineId = :medicineId")
     public Optional<Medicine> findByPharmacyIdAndMedicineId(@Param("pharmacyId") String pharmacyId, @Param("medicineId") String medicineId);

	

}
