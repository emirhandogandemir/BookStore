package com.bookstore.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.business.abstracts.CustomerService;
import com.bookstore.business.constants.Messages;
import com.bookstore.core.utilities.results.DataResult;
import com.bookstore.core.utilities.results.Result;
import com.bookstore.core.utilities.results.SuccessDataResult;
import com.bookstore.core.utilities.results.SuccessResult;
import com.bookstore.domain.Customer;
import com.bookstore.domain.dtos.CustomerDto;
import com.bookstore.domain.mapper.CustomerMapper;
import com.bookstore.repository.CustomerRepository;

@Service
public class CustomerManager implements CustomerService {

	private final CustomerRepository customerRepository;
	private final CustomerMapper customerMapper;
	
	
	public CustomerManager(CustomerRepository customerRepository,CustomerMapper customerMapper) {
		
		this.customerRepository = customerRepository;
		this.customerMapper=customerMapper;
	}

	@Override
	public Result add(CustomerDto customerDto) {
		this.customerRepository.save(customerMapper.dtoToModel(customerDto));
		return new SuccessResult(Messages.customerAdded);
	}

	@Override
	public Result update(CustomerDto customerDto) {
		this.customerRepository.save(customerMapper.dtoToModel(customerDto));
		return new SuccessResult(Messages.customerUpdated);
	}

	@Override
	public Result delete(int id) {
		this.customerRepository.deleteById(id);
		return new SuccessResult(Messages.customerDeleted);
		
	}

	@Override
	public DataResult<Customer> getById(int id) {
		return new SuccessDataResult<Customer>(this.customerRepository.getById(id));
	}

	@Override
	public DataResult<Customer> getByFirstName(String firstName) {
	return new SuccessDataResult<Customer>(this.customerRepository.getByFirstName(firstName));
	}

	@Override
	public DataResult<Customer> getByLastName(String lastName) {
		return new SuccessDataResult<Customer>(this.customerRepository.getByLastName(lastName));
	}

	@Override
	public DataResult<Customer> getByPhoneNumber(String phoneNumber) {
		return new SuccessDataResult<Customer>(this.customerRepository.getByPhoneNumber(phoneNumber));
	}
	@Override
	public DataResult<List<Customer>> getAll() {
	return new SuccessDataResult<List<Customer>>(this.customerRepository.findAll());
	}

	@Override
	public int countGetAll() {
		return (int) this.customerRepository.count();
	}

}
