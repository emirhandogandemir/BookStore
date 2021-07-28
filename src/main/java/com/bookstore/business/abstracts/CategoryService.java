package com.bookstore.business.abstracts;

import com.bookstore.core.utilities.results.DataResult;
import com.bookstore.core.utilities.results.Result;
import com.bookstore.domain.Category;

public interface CategoryService {

	Result add(Category category);
	
	Result update(Category category);
	
	Result delete(int id);
	
	DataResult<Category> getById(int id);
	
	DataResult<Category> getByName(String name);
	
}
