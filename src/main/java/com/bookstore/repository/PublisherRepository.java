package com.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.domain.Publisher;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Integer> {

	Publisher getById(int id);
	
	Publisher getByName(String name);
}
