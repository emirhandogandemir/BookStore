package com.bookstore.business.abstracts;

import com.bookstore.core.utilities.results.DataResult;
import com.bookstore.core.utilities.results.Result;
import com.bookstore.domain.Admin;

public interface AdminService {

	Result add(Admin admin);
	
	Result update(Admin admin);
	
	Result delete(int id);
	
	DataResult<Admin>  getById(int id);
	
	DataResult<Admin>  getByFirstName(String firstName);
	
	DataResult<Admin>  getByLastName(String lastName);
	

	
}
