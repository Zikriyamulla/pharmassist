package com.pharmassist.mapper;

import org.springframework.stereotype.Component;

import com.pharmassist.entity.Admin;
import com.pharmassist.requestdtos.AdminRequest;
import com.pharmassist.responsedtos.AdminResponse;
@Component
public class AdminMapper {
	public Admin mapToAdmin(AdminRequest request, Admin admin) {
		admin.setEmail(request.getEmail());
		admin.setPassword(request.getPassword());
		admin.setPhoneNumber(request.getPhoneNumber());
		
		return admin;

	}


	public AdminResponse mapToAdminResponse(Admin user) {
		AdminResponse response= new AdminResponse();
		response.setEmail(user.getEmail());
		response.setAdminId(user.getAdminId());
		
		return response;

	}

}
