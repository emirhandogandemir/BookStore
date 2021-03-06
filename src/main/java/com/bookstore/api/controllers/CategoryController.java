package com.bookstore.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.business.abstracts.CategoryService;
import com.bookstore.core.utilities.results.DataResult;
import com.bookstore.core.utilities.results.Result;
import com.bookstore.domain.Category;
import com.bookstore.domain.dtos.CategoryDto;

@RestController
@RequestMapping("/api/categories/")
@CrossOrigin

public class CategoryController {

	private final CategoryService categoryService;

	
	public CategoryController(CategoryService categoryService) {
		
		this.categoryService = categoryService;
	}

	@PostMapping("add")
	public ResponseEntity<?> add(@Valid @RequestBody CategoryDto categoryDto) {
		return ResponseEntity.ok(this.categoryService.add(categoryDto));
	}

	@PostMapping("update")
	public ResponseEntity<?> update(@Valid @RequestBody CategoryDto categoryDto) {
		return ResponseEntity.ok(this.categoryService.update(categoryDto));
	}

	@PostMapping("delete")
	public Result delete(@RequestParam int id) {
		return this.categoryService.delete(id);
	}

	@GetMapping("getById")
	public DataResult<Category> getById(@RequestParam int id) {
		return this.categoryService.getById(id);
	}

	@GetMapping("getByName")
	public DataResult<Category> getByName(@RequestParam String name) {
		return this.categoryService.getByName(name);
	}

	@GetMapping("getAll")
	public DataResult<List<Category>> getAll() {
		return this.categoryService.getAll();
	}
	@GetMapping("countGetAll")
	public int countGetAll() {
		return this.categoryService.countGetAll();
	}

}
