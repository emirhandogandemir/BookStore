package com.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.domain.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{

	Admin getById(int id);
	
	Admin getByFirstName(String firstName);
	
	Admin getByLastName(String lastName);
	
}
