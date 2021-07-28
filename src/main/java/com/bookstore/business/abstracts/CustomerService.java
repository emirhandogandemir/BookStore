package com.bookstore.business.abstracts;

import java.util.List;

import com.bookstore.core.utilities.results.DataResult;
import com.bookstore.core.utilities.results.Result;
import com.bookstore.domain.Customer;

public interface CustomerService {

	Result add(Customer customer);
	
	Result update(Customer customer);
	
	Result delete(int id);
	
	DataResult<Customer> getById(int id);
	
	DataResult<Customer> getByFirstName(String firstName);

	DataResult<Customer> getByLastName(String lastName);
	
	DataResult<Customer> getByPhoneNumber(String phoneNumber);
	
	DataResult<List<Customer>> getAll();
}
