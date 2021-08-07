package com.bookstore.domain.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.bookstore.domain.Book;
import com.bookstore.domain.Publisher;
import com.bookstore.domain.dtos.BookDto;
import com.bookstore.domain.dtos.PublisherDto;

@Mapper(componentModel = "spring")
public interface PublisherMapper {

	PublisherDto modelToDto(Publisher publisher);
	
	Publisher dtoToModel(PublisherDto publisherDto);
	
	
}
