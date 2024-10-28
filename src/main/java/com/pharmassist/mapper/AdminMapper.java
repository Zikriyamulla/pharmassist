package com.pharmassist.mapper;

import com.pharmassist.entity.Admin;
import com.pharmassist.requestdtos.AdminRequest;
import com.pharmassist.responsedtos.AdminResponse;

public class AdminMapper {
	public Admin mapToUser(AdminRequest request, Admin admin) {
		admin.setEmail(request.getEmail());
		admin.setPassword(request.getPassword());
		admin.setPhoneNumber(request.getPhoneNumber());
		
		return admin;

	}


	public AdminResponse mapToUserResponse(Admin user) {
		AdminResponse response= new AdminResponse();
		response.setEmail(user.getEmail());
		response.setAdminId(user.getAdminId());
		
		return response;

	}

}
