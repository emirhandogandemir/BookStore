package com.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.domain.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	
	Customer getById(int id);
	
	Customer getByFirstName(String firstName);
	
	Customer getByLastName(String lastName);
	
	Customer getByPhoneNumber(String phoneNumber);
	
}
