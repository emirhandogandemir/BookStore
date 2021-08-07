package com.bookstore.domain.mapper;

import org.mapstruct.Mapper;

import com.bookstore.domain.Customer;
import com.bookstore.domain.dtos.CustomerDto;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

	CustomerDto modelToDto(Customer customer);
	
	Customer dtoToModel(CustomerDto customerDto);
}
