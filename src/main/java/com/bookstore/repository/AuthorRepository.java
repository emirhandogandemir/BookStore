package com.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.domain.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

	Author getById(int id);
	
	Author getByFirstName(String firstName);
	
	Author getByLastName(String lastName);
	
}
