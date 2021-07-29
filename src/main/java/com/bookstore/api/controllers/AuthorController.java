package com.bookstore.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.business.abstracts.AuthorService;
import com.bookstore.core.utilities.results.DataResult;
import com.bookstore.core.utilities.results.Result;
import com.bookstore.domain.Author;

@RestController
@RequestMapping("/api/authors")
@CrossOrigin
public class AuthorController {

	private AuthorService authorService;

	@Autowired
	public AuthorController(AuthorService authorService) {
		super();
		this.authorService = authorService;
	}
	public ResponseEntity<?> add(@Valid @RequestBody Author author){
		return ResponseEntity.ok(this.authorService.add(author));
	}
	public ResponseEntity<?> update(@Valid @RequestBody Author author){
		return ResponseEntity.ok(this.authorService.update(author));
	}
	public Result delete(@RequestParam int id) {
		return this.authorService.delete(id);
	}
	public DataResult<Author> getById(@RequestParam int id){
		return this.authorService.getById(id);
	}
	public DataResult<Author> getByFirstName(@RequestParam String firstName){
		return this.authorService.getByFirstName(firstName);
	}
	public DataResult<Author> getByLastName(@RequestParam String lastName){
		return this.authorService.getByLastName(lastName);
	}
	public DataResult<List<Author>> getAll(){
		return this.authorService.getAll();
	}
	
}
