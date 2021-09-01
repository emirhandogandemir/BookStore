package com.bookstore.business.abstracts;

import java.util.List;
import java.util.Optional;

import com.bookstore.core.utilities.results.DataResult;
import com.bookstore.core.utilities.results.Result;
import com.bookstore.domain.Cart;
import com.bookstore.domain.dtos.CartDto;

public interface CartService {

	Result add(CartDto cartDto);
	
	Result update(CartDto cartDto);
	
	Result delete(int id);
	
	DataResult<Cart> getById(int id);
	DataResult<List<Cart>> getAll();
	DataResult<Optional<Cart>> getByUser_id(int id);
	
}
