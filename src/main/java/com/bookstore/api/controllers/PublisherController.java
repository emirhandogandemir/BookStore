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

import com.bookstore.business.abstracts.PublisherService;
import com.bookstore.core.utilities.results.DataResult;
import com.bookstore.core.utilities.results.Result;
import com.bookstore.domain.Publisher;
import com.bookstore.domain.dtos.PublisherDto;

@RestController
@RequestMapping("/api/publishers")
@CrossOrigin
public class PublisherController {

	private PublisherService publisherService;

	@Autowired
	public PublisherController(PublisherService publisherService) {
		super();
		this.publisherService = publisherService;
	}

	@PostMapping("add")
	public ResponseEntity<?> add(@Valid @RequestBody PublisherDto publisher) {
		return ResponseEntity.ok(this.publisherService.add(publisher));
	}

	@PostMapping("update")
	public ResponseEntity<?> update(@Valid @RequestBody PublisherDto publisher) {
		return ResponseEntity.ok(this.publisherService.update(publisher));
	}

	@PostMapping("delete")
	public Result delete( @RequestParam int id) {
		return this.publisherService.delete(id);
	}

	@GetMapping("getById")
	public DataResult<Publisher> getById(@RequestParam int id) {
		return this.publisherService.getById(id);
	}

	@GetMapping("getByName")
	public DataResult<Publisher> getByName(@RequestParam String name) {
		return this.publisherService.getByName(name);
	}

	@GetMapping("getAll")
	public DataResult<List<Publisher>> getAll() {
		return this.publisherService.getAll();
	}
}
