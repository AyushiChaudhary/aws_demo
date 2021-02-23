package com.cg.oes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.oes.entity.Admin;
import com.cg.oes.service.IAdminService;

@RestController
@RequestMapping(value = "/OES")
@CrossOrigin(origins="http://localhost:4200")
public class AdminController {
	
	@Autowired 
	private IAdminService IAdminService;
	/**
	 * method name: login
	 * method desc: admin will login  by passing  adminId and password through uri by calling method of service class.
	 * parameters:  Admin type-admin
	 * returns:    String
	 * method type: get
	 * author name: Ruchi
	 */ 
	@PostMapping("/alogin")
	public String login(@RequestBody Admin admin)
	{
		System.out.println("doing"+admin);
		return IAdminService.login(admin) ;
	}			
	
}