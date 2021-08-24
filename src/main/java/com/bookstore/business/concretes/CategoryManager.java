package com.bookstore.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.business.abstracts.CategoryService;
import com.bookstore.business.constants.Messages;
import com.bookstore.core.utilities.results.DataResult;
import com.bookstore.core.utilities.results.Result;
import com.bookstore.core.utilities.results.SuccessDataResult;
import com.bookstore.core.utilities.results.SuccessResult;
import com.bookstore.domain.Category;
import com.bookstore.domain.dtos.CategoryDto;
import com.bookstore.domain.mapper.CategoryMapper;
import com.bookstore.repository.CategoryRepository;

@Service
public class CategoryManager implements CategoryService {

	private final CategoryRepository categoryRepository;
	private final CategoryMapper categoryMapper;
	
	
	public CategoryManager(CategoryRepository categoryRepository,CategoryMapper categoryMapper) {
		
		this.categoryRepository = categoryRepository;
		this.categoryMapper= categoryMapper;
	}

	@Override
	public Result add(CategoryDto categoryDto) {
		this.categoryRepository.save(categoryMapper.dtoToModel(categoryDto));
		return new SuccessResult(Messages.categoryAdded);
	}

	@Override
	public Result update(CategoryDto categoryDto) {
		this.categoryRepository.save(categoryMapper.dtoToModel(categoryDto));
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

	@Override
	public DataResult<List<Category>> getAll() {
		return new SuccessDataResult<List<Category>>(this.categoryRepository.findAll());
	}

	@Override
	public int countGetAll() {
	return (int) this.categoryRepository.count();
	}

}
