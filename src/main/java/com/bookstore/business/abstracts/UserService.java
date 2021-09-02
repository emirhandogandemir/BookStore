package com.bookstore.business.abstracts;

import java.util.List;
import java.util.Optional;

import com.bookstore.core.entities.User;
import com.bookstore.core.entities.dtos.UserLoginDto;
import com.bookstore.core.entities.dtos.UserRegisterDto;
import com.bookstore.core.utilities.results.DataResult;
import com.bookstore.core.utilities.results.Result;

public interface UserService {

	Result add(User user);

	Result update(User user);

	Result delete(int id);

	DataResult<User> getById(int id);

	DataResult<List<User>> getAll();

	DataResult<User> getUserByEmail(String email);

	List<User> findAll();

	User findOne(String username);

	User save(UserRegisterDto user);
	
	int countGetAll();
	
  Optional< User> findTopByOrderByIdDesc();
}
