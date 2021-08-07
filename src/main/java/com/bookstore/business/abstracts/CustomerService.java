package com.bookstore.business.abstracts;

import java.util.List;

import com.bookstore.core.utilities.results.DataResult;
import com.bookstore.core.utilities.results.Result;
import com.bookstore.domain.Customer;
import com.bookstore.domain.dtos.CustomerDto;

public interface CustomerService {

	Result add(CustomerDto customer);
	
	Result update(CustomerDto customer);
	
	Result delete(int id);
	
	DataResult<Customer> getById(int id);
	
	DataResult<Customer> getByFirstName(String firstName);

	DataResult<Customer> getByLastName(String lastName);
	
	DataResult<Customer> getByPhoneNumber(String phoneNumber);
	
	DataResult<List<Customer>> getAll();
}
