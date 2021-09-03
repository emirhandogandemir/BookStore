package com.bookstore.domain.mapper;

import org.mapstruct.Mapper;

import com.bookstore.core.entities.User;
import com.bookstore.core.entities.dtos.UserRegisterDto;
import com.bookstore.domain.dtos.UserDto;

@Mapper(componentModel="spring")
public interface UserMapper {

	UserDto modelToDto(User book);
	User dtoToModel(UserRegisterDto bookDto);
	
}
