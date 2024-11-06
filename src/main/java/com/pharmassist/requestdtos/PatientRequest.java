package com.pharmassist.requestdtos;

import java.time.LocalDate;

import com.pharmassist.enums.Gender;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class PatientRequest {
	@NotNull(message="PatientName Cannot be Null")
	@NotBlank(message="PatientName Cannot be blank")
	@Pattern(regexp = "^[a-zA-Z]+$",message="The PatientName must only contain alphabets")
	private String name;
	
	@NotBlank(message="Phone Number Cannot be blank")
	@NotNull(message="Phone Number cannot  be null")
	@Pattern(regexp = "^[6-9][0-9]{9}$"
			, message="Invalid phone number")
	private String phoneNumber;
	
	@NotBlank(message="Email Cannot be blank")
	@NotNull(message="Email Cannot be null")
	@Pattern(regexp = "^[a-zA-Z\\._%+-]+@gmail\\.com$"
			, message="Invalid Gmail Id")
	private String email;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	private LocalDate dateOfBirth;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
}
