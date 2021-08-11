package com.bookstore.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.business.abstracts.CustomerService;
import com.bookstore.core.utilities.results.DataResult;
import com.bookstore.core.utilities.results.Result;
import com.bookstore.domain.Customer;
import com.bookstore.domain.dtos.CustomerDto;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

	private final CustomerService customerService;

	
	public CustomerController(CustomerService customerService) {
		
		this.customerService = customerService;
	}

	@PostMapping("add")
	public ResponseEntity<?> add(@Valid @RequestBody CustomerDto customerDto) {
		return ResponseEntity.ok(this.customerService.add(customerDto));
	}

	@PostMapping("update")
	public ResponseEntity<?> update(@Valid @RequestBody CustomerDto customerDto) {
		return ResponseEntity.ok(this.customerService.update(customerDto));
	}

	@PostMapping("delete")
	public Result delete(@RequestParam int id) {
		return this.customerService.delete(id);
	}

	@GetMapping("getById")
	public DataResult<Customer> getById(@RequestParam int id) {
		return this.customerService.getById(id);
	}

	@GetMapping("getByFirstName")
	public DataResult<Customer> getByFirstName(@RequestParam String firstName) {
		return this.customerService.getByFirstName(firstName);
	}

	@GetMapping("getByLastName")
	public DataResult<Customer> getByLastName(@RequestParam String lastName) {
		return this.customerService.getByLastName(lastName);
	}

	@GetMapping("getByPhoneNumber")
	public DataResult<Customer> getByPhoneNumber(@RequestParam String phoneNumber) {
		return this.customerService.getByPhoneNumber(phoneNumber);
	}

	@GetMapping("getAll")
	public DataResult<List<Customer>> getAll() {
		return this.customerService.getAll();
	}
}
