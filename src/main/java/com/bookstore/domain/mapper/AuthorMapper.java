package com.bookstore.domain.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.bookstore.domain.Author;
import com.bookstore.domain.Book;
import com.bookstore.domain.dtos.AuthorDto;
import com.bookstore.domain.dtos.BookDto;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

	AuthorDto modelToDto(Author author);
	
	Author dtoToModel(AuthorDto authorDto);
	
	
	
	
}
