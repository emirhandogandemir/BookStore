package com.bookstore.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.business.abstracts.CategoryService;
import com.bookstore.core.utilities.results.DataResult;
import com.bookstore.core.utilities.results.Result;
import com.bookstore.domain.Category;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	private CategoryService categoryService;

	@Autowired
	public CategoryController(CategoryService categoryService) {
		super();
		this.categoryService = categoryService;
	}
	
	public ResponseEntity<?> add(@Valid @RequestBody Category category){
		return ResponseEntity.ok(this.categoryService.add(category));
	}
	public ResponseEntity<?> update(@Valid @RequestBody Category category){
		return ResponseEntity.ok(this.categoryService.update(category));
	}
	
	public Result delete(@RequestParam int id) {
		return this.categoryService.delete(id);
	}
	
	public DataResult<Category> getBYId(@RequestParam int id){
		return this.categoryService.getById(id);
	}
	public DataResult<Category> getByName(@RequestParam String name){
		return this.categoryService.getByName(name);
	}
	public DataResult<List<Category>> getAll(){
		return this.categoryService.getAll();
	}
	
	
}
