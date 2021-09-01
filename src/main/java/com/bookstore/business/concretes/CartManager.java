package com.bookstore.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bookstore.business.abstracts.CartService;
import com.bookstore.business.constants.Messages;
import com.bookstore.core.utilities.results.DataResult;
import com.bookstore.core.utilities.results.Result;
import com.bookstore.core.utilities.results.SuccessDataResult;
import com.bookstore.core.utilities.results.SuccessResult;
import com.bookstore.domain.Cart;
import com.bookstore.domain.dtos.CartDto;
import com.bookstore.domain.mapper.CartMapper;
import com.bookstore.repository.CartRepository;

@Service
public class CartManager implements CartService{

	private final CartRepository cartRepository;
	private final CartMapper cartMapper;
	
	
	public CartManager(CartRepository cartRepository,CartMapper cartMapper) {
		this.cartRepository = cartRepository;
		this.cartMapper=cartMapper;
	}

	@Override
	public Result add(CartDto cartDto) {
		this.cartRepository.save(cartMapper.dtoToModel(cartDto));
		return new SuccessResult(Messages.cartAdded);
	}

	@Override
	public Result update(CartDto cartDto) {
		this.cartRepository.save(cartMapper.dtoToModel(cartDto));
		return new SuccessResult(Messages.cartUpdated);
	}

	@Override
	public Result delete(int id) {
		this.cartRepository.deleteById(id);
		return new SuccessResult(Messages.cartDeleted);
	}

	@Override
	public DataResult<Cart> getById(int id) {
		return new SuccessDataResult<Cart> (this.cartRepository.getById(id));
	}

	@Override
	public DataResult<List<Cart>> getAll() {
		return new SuccessDataResult<List<Cart>> (this.cartRepository.findAll());
	}

	@Override
	public DataResult<Optional<Cart>> getByUser_id(int id) {
		return new SuccessDataResult<Optional<Cart>>(this.cartRepository.getByUser_id(id));
	}

}
