package com.bookstore.domain.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.bookstore.domain.Book;
import com.bookstore.domain.dtos.BookDto;

@Mapper(componentModel = "spring")
public interface BookMapper {
	
	BookDto modelToDto(Book book);
	
	Book dtoToModel(BookDto bookDto);
	
	
}
