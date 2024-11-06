package com.pharmassist.requestdtos;

import java.time.LocalDate;

import com.pharmassist.enums.Forms;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class MedicineRequest {
	@NotNull(message="MedicineName Cannot be Null")
	@NotBlank(message="MedicineName Cannot be blank")
	@Pattern(regexp = "^[a-zA-Z]+$",message="The PharmacyName must only contain alphabets")
	private String name;
	
	@NotNull(message="Category Cannot be Null")
	 @NotBlank(message = "Category cannot be blank")
	    @Pattern(regexp = "^[A-Za-z\\s]+$", message = "Category must contain only letters and spaces")
	private String category;
	
	@NotNull(message="Ingredients Cannot be Null")
	@NotBlank(message = "Ingredients cannot be blank")
    @Pattern(regexp = "^[A-Za-z0-9,\\s]+$", message = "Ingredients must contain only letters, numbers, commas, and spaces")
	private String ingredients;
	
	@NotNull(message="Dosage Cannot be Null")
	@NotBlank(message = "Dosage cannot be blank")
    @Min(value = 1, message = "Dosage must be at least 1 mg")
	private int dossageInMg;
	@NotNull(message="Forms Cannot be Null")
	@Enumerated(EnumType.STRING)
	private Forms forms;
	
	@NotNull(message="Manufacture Cannot be Null")
	 @NotBlank(message = "Manufacture name cannot be blank")
	    @Pattern(regexp = "^[A-Za-z0-9\\s]+$", message = "Manufacture name must contain only letters, numbers, and spaces")
	    private String manufacture;

	 @NotBlank(message = "Stock quantity cannot be blank")
	    @NotNull(message = "Stock quantity cannot be null")
	    @Min(value = 0, message = "Stock quantity cannot be negative")
	    private int stockQuantity;
	 @NotBlank(message = "Expiration date cannot be blank")
	    @NotNull(message = "Expiration date cannot be null")
	    @Future(message = "Expiration date must be in the future")
	    private LocalDate expireDate;

	 @NotBlank(message = "Price cannot be blank")
	    @NotNull(message = "Price cannot be null")
	    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0")
	    private double price;
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
