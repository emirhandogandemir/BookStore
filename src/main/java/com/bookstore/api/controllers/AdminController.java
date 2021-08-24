package com.bookstore.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.business.abstracts.AdminService;
import com.bookstore.core.utilities.results.DataResult;
import com.bookstore.core.utilities.results.Result;
import com.bookstore.domain.Admin;

@RestController
@RequestMapping("/api/admins/")
@CrossOrigin
public class AdminController {

	private final AdminService adminService;

	
	public AdminController(AdminService adminService) {
		
		this.adminService = adminService;
	}

	@PostMapping("add")
	public ResponseEntity<?> add(@Valid @RequestBody Admin admin) {
		return ResponseEntity.ok(this.adminService.add(admin));
	}

	@PostMapping("update")
	public ResponseEntity<?> update(@Valid @RequestBody Admin admin) {
		return ResponseEntity.ok(this.adminService.update(admin));
	}

	@PostMapping("delete")
	public Result delete(@RequestParam int id) {
		return this.adminService.delete(id);
	}

	@GetMapping("getById")
	public DataResult<Admin> getById(@RequestParam int id) {
		return this.adminService.getById(id);
	}

	@GetMapping("getByFirstName")
	public DataResult<Admin> getByFirstName(@RequestParam String firstName) {
		return this.adminService.getByFirstName(firstName);
	}

	@GetMapping("getByLastName")
	public DataResult<Admin> getByLastName(@RequestParam String lastName) {
		return this.adminService.getByLastName(lastName);
	}
}
