package com.bookstore.api.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.business.abstracts.CartService;
import com.bookstore.core.utilities.results.DataResult;
import com.bookstore.core.utilities.results.SuccessDataResult;
import com.bookstore.domain.Cart;
import com.bookstore.domain.dtos.CartDto;

@RestController
@RequestMapping("/api/carts/")
@CrossOrigin
public class CartController {

	private final CartService cartService;

	public CartController(CartService cartService) {
		this.cartService = cartService;
	}

	@PostMapping("add")
	public ResponseEntity<?> add(@Valid @RequestBody CartDto cartDto) {
		return ResponseEntity.ok(this.cartService.add(cartDto));
	}

	@PostMapping("update")
	public ResponseEntity<?> update(@Valid @RequestBody CartDto cartDto) {
		return ResponseEntity.ok(this.cartService.update(cartDto));
	}

	@PostMapping("delete")
	public ResponseEntity<?> delete(@RequestParam int id) {
		return ResponseEntity.ok(this.cartService.delete(id));
	}

	@GetMapping("getAll")
	public DataResult<List<Cart>> getAll() {
		return this.cartService.getAll();
	}

	@GetMapping("getById")
	public DataResult<Cart> getById(@RequestParam int id) {
		return this.cartService.getById(id);
	}

	@GetMapping("getByUserId")
	public DataResult<Optional<Cart>> getByUserId(@RequestParam int userId) {
		return this.cartService.getByUser_id(userId);
	}

}
