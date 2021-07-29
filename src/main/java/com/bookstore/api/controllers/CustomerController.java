package com.bookstore.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.business.abstracts.CustomerService;
import com.bookstore.core.utilities.results.DataResult;
import com.bookstore.core.utilities.results.Result;
import com.bookstore.domain.Customer;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

	private CustomerService customerService;

	@Autowired
	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}
	
	public ResponseEntity<?> add(@Valid @RequestBody Customer customer){
		return ResponseEntity.ok(this.customerService.add(customer));
	}
	public ResponseEntity<?> update(@Valid @RequestBody Customer customer){
		return ResponseEntity.ok(this.customerService.update(customer));
	}
	public Result delete(@RequestParam int id) {
		return this.customerService.delete(id);
	}
	public DataResult<Customer> getById(@RequestParam int customerId){
		return this.customerService.getById(customerId);
	}
	public DataResult<Customer> getByFirstName(@RequestParam String firstName){
		return this.customerService.getByFirstName(firstName);
	}
	public DataResult<Customer> getByLastName(@RequestParam String lastName){
		return this.customerService.getByLastName(lastName);
	}
	public DataResult<Customer> getByPhoneNumber(@RequestParam String phoneNumber){
		return this.customerService.getByPhoneNumber(phoneNumber);
	}
	public DataResult<List<Customer>> getAll(){
		return this.customerService.getAll();
	}
}
