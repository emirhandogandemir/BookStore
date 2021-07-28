package com.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.domain.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
