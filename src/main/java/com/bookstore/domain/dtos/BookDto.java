package com.bookstore.domain.dtos;

import com.bookstore.domain.Author;
import com.bookstore.domain.Publisher;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BookDto {

	private int id;
	private String name;
	private String summary;
	private double price;
	private String editionNumber;
	private Publisher publisher;
	private Author author;
	
}
