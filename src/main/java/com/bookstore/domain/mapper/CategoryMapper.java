package com.bookstore.domain.mapper;

import org.mapstruct.Mapper;

import com.bookstore.domain.Category;
import com.bookstore.domain.dtos.CategoryDto;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

	CategoryDto modelToDto(Category category);
	
	Category dtoToModel(CategoryDto categoryDto);
}
