package com.bookstore.domain.dtos;

import java.util.List;

import com.bookstore.domain.Author;
import com.bookstore.domain.Category;
import com.bookstore.domain.Image;
import com.bookstore.domain.Publisher;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {

	private int id;
	private String name;
	private String summary;
	private double price;
	private String editionNumber;
	private Publisher publisher;
	private Author author;
	private Image image;
	private Category category;

	
	
}
