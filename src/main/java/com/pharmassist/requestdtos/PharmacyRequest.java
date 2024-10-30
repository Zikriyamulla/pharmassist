package com.pharmassist.requestdtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class PharmacyRequest {
	
	@NotNull(message="PharmacyName Cannot be Null")
	@NotBlank(message="PharmacyName Cannot be blank")
	@Pattern(regexp = "^[a-zA-Z]+$",message="The PharmacyName must only contain alphabets")
	private String name;
	
	@NotNull(message="Gstno Cannot be Null")
	@NotBlank(message="Gstno Cannot be blank")
	 @Pattern(
		        regexp = "^[0-9]{2}[A-Z]{5}[0-9]{4}[A-Z]{1}[1-9A-Z]{1}Z[0-9A-Z]{1}$",
		        message = "Invalid GST number format"
		    )
	private String gstNo;
	
	@NotNull(message="LicenceNo Cannot be Null")
	@NotBlank(message="LicenceNo Cannot be blank")
	   @Pattern(
		        regexp = "^[A-Z]{2}[0-9]{2,4}[A-Z][0-9]{3}$",
		        message = "Invalid license number format"
		    )
	private String licenceNo;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGstNo() {
		return gstNo;
	}
	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}
	public String getLicenceNo() {
		return licenceNo;
	}
	public void setLicenceNo(String licenceNo) {
		this.licenceNo = licenceNo;
	}
	

}
