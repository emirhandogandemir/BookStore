package com.bookstore.domain.mapper;

import org.mapstruct.Mapper;

import com.bookstore.domain.Image;
import com.bookstore.domain.dtos.ImageDto;

@Mapper(componentModel = "spring")
public interface ImageMapper {

	ImageDto modelToDto(Image image);
	
	Image dtoToModel(ImageDto imageDto);
	
}
