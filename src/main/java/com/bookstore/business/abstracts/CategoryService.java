package com.bookstore.business.abstracts;

import java.util.List;

import com.bookstore.core.utilities.results.DataResult;
import com.bookstore.core.utilities.results.Result;
import com.bookstore.domain.Category;
import com.bookstore.domain.dtos.CategoryDto;

public interface CategoryService {

	Result add(CategoryDto category);
	
	Result update(CategoryDto category);
	
	Result delete(int id);
	
	DataResult<Category> getById(int id);
	
	DataResult<Category> getByName(String name);
	
	DataResult<List<Category>> getAll();
}
