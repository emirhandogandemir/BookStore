package com.bookstore.domain.mapper;

import org.mapstruct.Mapper;

import com.bookstore.domain.Book;
import com.bookstore.domain.Cart;
import com.bookstore.domain.dtos.BookDto;
import com.bookstore.domain.dtos.CartDto;


@Mapper(componentModel = "spring")
public interface CartMapper {

	CartDto modelToDto(Cart cart);
	Cart dtoToModel(CartDto cartDto);
	
}


