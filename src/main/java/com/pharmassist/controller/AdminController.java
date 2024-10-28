package com.pharmassist.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pharmassist.requestdtos.AdminRequest;
import com.pharmassist.responsedtos.AdminResponse;
import com.pharmassist.service.AdminService;
import com.pharmassist.util.AppResponseBuilder;
import com.pharmassist.util.ResponseStructure;

import jakarta.validation.Valid;



@RestController
public class AdminController {
	private AdminService adminService;
	private final AppResponseBuilder responseBuilder;
	public AdminController(AdminService adminService, AppResponseBuilder responseBuilder) {
		super();
		this.adminService = adminService;
		this.responseBuilder = responseBuilder;
	}
	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<AdminResponse>> saveAdmin(@RequestBody @Valid AdminRequest adminRequest){
		 AdminResponse response=adminService.saveAdmin(adminRequest);
		 return  responseBuilder.success(HttpStatus.CREATED, "Admin Created", response);
		
	}
	
	
	

}
