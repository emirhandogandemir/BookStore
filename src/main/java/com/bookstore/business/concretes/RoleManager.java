package com.bookstore.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.business.abstracts.RoleService;
import com.bookstore.core.entities.Role;
import com.bookstore.core.repository.RoleRepository;
@Service(value = "roleService")
public class RoleManager implements RoleService {

	@Autowired
	RoleRepository roleRepository;
	
	@Override
	public Role findByName(String name) {
		
	 Role role =roleRepository.findRoleByName(name);
	 return role;
	}

}
