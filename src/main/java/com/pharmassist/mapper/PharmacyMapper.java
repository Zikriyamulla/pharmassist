package com.pharmassist.mapper;

import com.pharmassist.entity.Pharmacy;
import com.pharmassist.requestdtos.PharmacyRequest;
import com.pharmassist.responsedtos.PharmacyResponse;

public class PharmacyMapper {
	public Pharmacy mapToPharmacy(PharmacyRequest request, Pharmacy pharmacy) {
		pharmacy.setName(request.getName());
		pharmacy.setGstNo(request.getGstNo());
		pharmacy.setLicenceNo(request.getLicenceNo());
		return pharmacy;
	}
	public PharmacyResponse mapToPharmacyResponse(Pharmacy pharmacy) {
		PharmacyResponse response=new PharmacyResponse();
		response.setName(pharmacy.getName());
		response.setGstNo(pharmacy.getGstNo());
		response.setLicenceNo(pharmacy.getLicenceNo());
		
		return response;
		
	}

}
