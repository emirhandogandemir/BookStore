package com.bookstore.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.domain.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, Integer> {

	Image getById(int id);
	
	
}
