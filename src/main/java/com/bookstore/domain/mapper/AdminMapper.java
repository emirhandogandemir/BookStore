package com.bookstore.domain.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.bookstore.domain.Admin;
import com.bookstore.domain.Book;
import com.bookstore.domain.dtos.AdminDto;
import com.bookstore.domain.dtos.BookDto;

@Mapper(componentModel = "spring")
public interface AdminMapper {
	
	AdminDto modelToDto(Admin admin);
	
	Admin dtoToModel (AdminDto adminDto);

}
