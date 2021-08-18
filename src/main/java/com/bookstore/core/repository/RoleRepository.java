package com.bookstore.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.core.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

	Role findByName(String name);
	
}
