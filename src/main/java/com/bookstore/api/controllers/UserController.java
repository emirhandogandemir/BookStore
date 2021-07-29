package com.bookstore.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.business.abstracts.UserService;
import com.bookstore.core.entities.User;
import com.bookstore.core.utilities.results.DataResult;
import com.bookstore.core.utilities.results.Result;

@RestController
@RequestMapping("/api/users")
public class UserController {

	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	public ResponseEntity<?> add(@Valid @RequestParam User user){
		return ResponseEntity.ok(this.userService.add(user));
	}
	public ResponseEntity<?> update(@Valid @RequestParam User user){
		return ResponseEntity.ok(this.userService.update(user));
	}
	public Result delete(@RequestParam int id) {
		return this.userService.delete(id);
	}
	public DataResult<User> getById(@RequestParam int id){
		return this.userService.getById(id);
	}
	public DataResult<User> getUserByEmail(@RequestParam String email){
		return this.userService.getUserByEmail(email);
	}
	public DataResult<List<User>> getAll(){
		return this.userService.getAll();
	}
}
