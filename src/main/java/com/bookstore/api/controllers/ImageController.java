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

import com.bookstore.business.abstracts.ImageService;
import com.bookstore.core.utilities.results.DataResult;
import com.bookstore.core.utilities.results.Result;
import com.bookstore.domain.Image;

@RestController
@RequestMapping("/api/images")
@CrossOrigin
public class ImageController {

	private ImageService imageService;

	@Autowired
	public ImageController(ImageService imageService) {
		super();
		this.imageService = imageService;
	}
	
	public ResponseEntity<?> add(@Valid @RequestBody Image image){
		return ResponseEntity.ok(this.imageService.add(image));
	}
	public ResponseEntity<?> update(@Valid @RequestBody Image image){
		return ResponseEntity.ok(this.imageService.update(image));
	}
	public Result delete(@RequestParam int id) {
		return this.imageService.delete(id);
	}
	public DataResult<Image> getById(@RequestParam int id){
		return this.imageService.getById(id);
	}
	public DataResult<List<Image>> getByBook_Id(@RequestParam int bookId){
		return this.imageService.getByBook_Id(bookId);
	}
}
