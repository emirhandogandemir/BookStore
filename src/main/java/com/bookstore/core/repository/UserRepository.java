package com.bookstore.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.core.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	User getById(int id);
	
	User getByEmail(String email);
	
}
