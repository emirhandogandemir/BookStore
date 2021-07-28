package com.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

	Category getById(int id);
	
	Category getByName(String name);
	
}
