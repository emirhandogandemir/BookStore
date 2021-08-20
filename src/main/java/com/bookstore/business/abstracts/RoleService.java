package com.bookstore.business.abstracts;

import com.bookstore.core.entities.Role;

public interface RoleService {
	Role findByName(String name);
}
