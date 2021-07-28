package com.bookstore.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.business.abstracts.CategoryService;
import com.bookstore.business.constants.Messages;
import com.bookstore.core.utilities.results.DataResult;
import com.bookstore.core.utilities.results.Result;
import com.bookstore.core.utilities.results.SuccessDataResult;
import com.bookstore.core.utilities.results.SuccessResult;
import com.bookstore.domain.Category;
import com.bookstore.repository.CategoryRepository;

@Service
public class CategoryManager implements CategoryService {

	private CategoryRepository categoryRepository;
	
	@Autowired
	public CategoryManager(CategoryRepository categoryRepository) {
		super();
		this.categoryRepository = categoryRepository;
	}

	@Override
	public Result add(Category category) {
		this.categoryRepository.save(category);
		return new SuccessResult(Messages.categoryAdded);
	}

	@Override
	public Result update(Category category) {
		this.categoryRepository.save(category);
		return new SuccessResult(Messages.categoryUpdated);
	}

	@Override
	public Result delete(int id) {
		this.categoryRepository.deleteById(id);
		return new SuccessResult(Messages.categoryDeleted);
	}

	@Override
	public DataResult<Category> getById(int id) {
		return new SuccessDataResult<Category>(this.categoryRepository.getById(id));
	}

	@Override
	public DataResult<Category> getByName(String name) {
		return new SuccessDataResult<Category>(this.categoryRepository.getByName(name));
	}

}
