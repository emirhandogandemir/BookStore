package com.bookstore.repository;


import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.domain.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

	
	Book getById(int id);
	
	
	Book getByName(String name);
	
	//List<Book> findByNameOrderName(String name);
	
	List<Book> getByAuthor_id(int authorId);
	
	List<Book> getByPublisher_id(int publisherId);
	
	List<Book> getByCategory_Id(int categoryId);
	
}
