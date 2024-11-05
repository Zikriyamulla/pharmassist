package com.pharmassist.responsedtos;

import java.time.LocalDate;

import com.pharmassist.enums.Forms;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class MedicineResponse {
	private String medicineId;
	private String name;
	private String category;
	private String ingredients;
	private int dossageInMg;
	@Enumerated(EnumType.STRING)
	private Forms forms;
	private String manufacture;
	private int stockQuantity;
	private LocalDate expireDate;
	private double price;
	public String getMedicineId() {
		return medicineId;
	}
	public void setMedicineId(String medicineId) {
		this.medicineId = medicineId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getIngredients() {
		return ingredients;
	}
	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}
	public int getDossageInMg() {
		return dossageInMg;
	}
	public void setDossageInMg(int dossageInMg) {
		this.dossageInMg = dossageInMg;
	}
	public Forms getForms() {
		return forms;
	}
	public void setForms(Forms forms) {
		this.forms = forms;
	}
	public String getManufacture() {
		return manufacture;
	}
	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}
	public int getStockQuantity() {
		return stockQuantity;
	}
	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
	public LocalDate getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(LocalDate expireDate) {
		this.expireDate = expireDate;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	

}
