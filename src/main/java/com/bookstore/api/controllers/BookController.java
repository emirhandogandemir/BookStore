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

import com.bookstore.business.abstracts.BookService;
import com.bookstore.core.aspects.performance.Performance;
import com.bookstore.core.utilities.results.DataResult;
import com.bookstore.core.utilities.results.Result;
import com.bookstore.domain.Book;

@RestController
@RequestMapping("/api/books")
@CrossOrigin
public class BookController {

	private BookService bookService;

	@Autowired
	public BookController(BookService bookService) {
		super();
		this.bookService = bookService;
	}

	@PostMapping("add")
	public ResponseEntity<?> add(@Valid @RequestBody Book book) {
		return ResponseEntity.ok(this.bookService.add(book));
	}

	@PostMapping("update")
	public ResponseEntity<?> update(@Valid @RequestBody Book book) {
		return ResponseEntity.ok(this.bookService.update(book));
	}

	@PostMapping("delete")
	public Result delete(@RequestParam int id) {
		return this.bookService.delete(id);
	}

	@GetMapping("getById")
	public DataResult<Book> getById(@RequestParam int id) {
		return this.bookService.getById(id);
	}

	@GetMapping("getByName")
	public DataResult<Book> getByName(@RequestParam String name) {
		return this.bookService.getByName(name);
	}
	@GetMapping("getAll")
	public DataResult<List<Book>> getAll() {
		return this.bookService.getAll();
	}

	@GetMapping("getByAuthorId")
	public DataResult<List<Book>> getByAuthor_id(@RequestParam int authorId) {
		return this.bookService.getByAuthor_id(authorId);
	}

	@GetMapping("getByPublisherId")
	public DataResult<List<Book>> getByPublisher_id(@RequestParam int publisherId) {
		return this.bookService.getByPublisher_id(publisherId);
	}

	@GetMapping("getByCategoryId")
	public DataResult<List<Book>> getByCategory_Id(@RequestParam int categoryId) {
		return this.bookService.getByCategory_Id(categoryId);
	}

	@GetMapping("naber")
	public void naber() {
		this.bookService.naber();
	}
}
