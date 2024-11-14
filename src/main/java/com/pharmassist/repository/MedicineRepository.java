package com.pharmassist.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pharmassist.entity.Medicine;


public interface MedicineRepository extends JpaRepository<Medicine, String>{
	

	public List<Medicine> findMedicineByNameLikeIgnoreCaseOrIngredientsLikeIgnoreCase(String name, String ingredient);
	 
	

	

}
