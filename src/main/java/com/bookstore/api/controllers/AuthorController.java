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

import com.bookstore.business.abstracts.AuthorService;
import com.bookstore.core.utilities.results.DataResult;
import com.bookstore.core.utilities.results.Result;
import com.bookstore.domain.Author;
import com.bookstore.domain.dtos.AuthorDto;

@RestController
@RequestMapping("/api/authors/")
@CrossOrigin
public class AuthorController {

	private final AuthorService authorService;


	public AuthorController(AuthorService authorService) {
		
		this.authorService = authorService;
	}

	@PostMapping("add")
	public ResponseEntity<?> add(@Valid @RequestBody AuthorDto author) {
		return ResponseEntity.ok(this.authorService.add(author));
	}

	@PostMapping("update")
	public ResponseEntity<?> update(@Valid @RequestBody AuthorDto author) {
		return ResponseEntity.ok(this.authorService.update(author));
	}

	@PostMapping("delete")
	public Result delete(@RequestParam int id) {
		return this.authorService.delete(id);
	}

	@GetMapping("getById")
	public DataResult<Author> getById(@RequestParam int id) {
		return this.authorService.getById(id);
	}

	@GetMapping("getByFirstName")
	public DataResult<Author> getByFirstName(@RequestParam String firstName) {
		return this.authorService.getByFirstName(firstName);
	}
	@GetMapping("getByLastName")
	public DataResult<Author> getByLastName(@RequestParam String lastName) {
		return this.authorService.getByLastName(lastName);
	}

	@GetMapping("getAll")
	public DataResult<List<Author>> getAll() {
		return this.authorService.getAll();
	}

}
