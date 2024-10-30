package com.pharmassist.requestdtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class AdminRequest {
	@NotBlank(message="Email Cannot be blank")
	@NotNull(message="Email Cannot be null")
	@Pattern(regexp = "^[a-zA-Z\\._%+-]+@gmail\\.com$"
			, message="Invalid Gmail Id")
	private String email;
	
	@NotBlank(message="Phone Number Cannot be blank")
	@NotNull(message="Phone Number cannot  be null")
	@Pattern(regexp = "^[6-9][0-9]{9}$"
			, message="Invalid phone number")
	private String phoneNumber;
	
	@NotBlank(message="Password Cannot be blank")
	@NotNull(message="Password cannot be null")
	@Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,12}$",
			message="Must contain at least one uppercase,lowercase,sepcialcharacter and number.the length should be maximum 8 minmum 12")
	private String password;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
