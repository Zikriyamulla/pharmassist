package com.pharmassist.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
public class AdminController {
	private AdminService adminService;
	private final AppResponseBuilder responseBuilder;
	public AdminController(AdminService adminService, AppResponseBuilder responseBuilder) {
		super();
		this.adminService = adminService;
		this.responseBuilder = responseBuilder;
	}
	@PostMapping("/admins")
	public ResponseEntity<ResponseStructure<AdminResponse>> saveAdmin(@RequestBody @Valid AdminRequest adminRequest){
		 AdminResponse response=adminService.saveAdmin(adminRequest);
		 return  responseBuilder.success(HttpStatus.CREATED, "Admin Created", response);
		
	}
	
	@GetMapping("/admins/{adminId}")
	public ResponseEntity<ResponseStructure<AdminResponse>> findAdminById(@PathVariable String adminId){
		AdminResponse response=adminService.findAdminById(adminId);
		return responseBuilder.success(HttpStatus.FOUND, "Admin Found", response);
		
	}
	
	@PutMapping("admins/{adminId}")
	public ResponseEntity<ResponseStructure<AdminResponse>> updateAdmin(@RequestBody AdminRequest adminRequest,@PathVariable String adminId){
		AdminResponse response=adminService.updateAdmin(adminRequest, adminId);
		return responseBuilder.success(HttpStatus.OK, "Admin Updated", response);
		
	}
	@GetMapping("/allAdmins")
	public ResponseEntity<ResponseStructure<List<AdminResponse>>> findAllAdmins(){
		List<AdminResponse> response= adminService.findAllAdmins();
		return responseBuilder.success(HttpStatus.FOUND, "Admins Found",response);

	}
	
	
	
	
	

}
