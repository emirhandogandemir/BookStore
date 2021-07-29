package com.bookstore.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.business.abstracts.AdminService;
import com.bookstore.core.utilities.results.DataResult;
import com.bookstore.core.utilities.results.Result;
import com.bookstore.domain.Admin;

@RestController
@RequestMapping("/api/admins")
@CrossOrigin
public class AdminController {

	private AdminService adminService;

	@Autowired
	public AdminController(AdminService adminService) {
		super();
		this.adminService = adminService;
	}
	public ResponseEntity<?> add(@Valid @RequestBody Admin admin){
		return ResponseEntity.ok(this.adminService.add(admin));
	}
	public ResponseEntity<?> update(@Valid @RequestBody Admin admin){
		return ResponseEntity.ok(this.adminService.add(admin));
	}
	
	public Result delete(@RequestParam int id) {
		return this.adminService.delete(id);
	}
	
	public DataResult<Admin> getById(@RequestParam int id){
		return this.adminService.getById(id);
	}
	
	public DataResult<Admin> getByFirstName(@RequestParam String firstName){
		return this.adminService.getByFirstName(firstName);
	}
	
	public DataResult<Admin> getByLastName(@RequestParam String lastName){
		return this.adminService.getByFirstName(lastName);
	}
}
