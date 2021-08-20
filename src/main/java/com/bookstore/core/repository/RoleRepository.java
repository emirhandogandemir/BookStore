package com.bookstore.core.repository;

import org.springframework.data.repository.CrudRepository;

import com.bookstore.core.entities.Role;

public interface RoleRepository extends CrudRepository<Role, Integer> {

	Role findRoleByName(String name);
	
}
