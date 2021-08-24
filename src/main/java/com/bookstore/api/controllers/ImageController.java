package com.bookstore.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bookstore.business.abstracts.ImageService;
import com.bookstore.core.utilities.results.DataResult;
import com.bookstore.core.utilities.results.Result;
import com.bookstore.domain.Image;



@RestController
@RequestMapping("/api/images/")
@CrossOrigin
public class ImageController {

	private final ImageService imageService;

	
	public ImageController(ImageService imageService) {
		
		this.imageService = imageService;
	}

	@PostMapping("add")
	public ResponseEntity<?> add(@ModelAttribute Image image,@RequestParam(value = "imageFile") MultipartFile imageFile) {
		return ResponseEntity.ok(this.imageService.add(image, imageFile));
	}
	

	@PostMapping("update")
	public ResponseEntity<?> update(@Valid @RequestBody Image image) {
		return ResponseEntity.ok(this.imageService.update(image));
	}

	@PostMapping("delete")
	public Result delete(@RequestParam int id) {
		return this.imageService.delete(id);
	}

	@GetMapping("getById")
	public DataResult<Image> getById(@RequestParam int id) {
		return this.imageService.getById(id);
	}

	@GetMapping("getAll")
	public DataResult<List<Image>> getAll(){
		return this.imageService.getAll();
	}
}
