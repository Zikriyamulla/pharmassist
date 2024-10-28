package com.pharmassist.controller;

import org.springframework.web.bind.annotation.RestController;

import com.pharmassist.service.AdminService;
import com.pharmassist.util.AppResponseBuilder;
@RestController
public class AdminController {
	private AdminService adminService;
	private final AppResponseBuilder responseBuilder;
	public AdminController(AdminService adminService, AppResponseBuilder responseBuilder) {
		super();
		this.adminService = adminService;
		this.responseBuilder = responseBuilder;
	}
	

}
