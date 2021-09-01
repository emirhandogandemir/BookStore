package com.bookstore.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.domain.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {

	Optional<Cart> getByUser_id(int id);
	
	Cart getById(int id);
}
