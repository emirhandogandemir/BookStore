package com.bookstore.business.abstracts;

import java.util.List;

import com.bookstore.core.utilities.results.DataResult;
import com.bookstore.core.utilities.results.Result;
import com.bookstore.domain.Book;
import com.bookstore.domain.dtos.BookDto;

public interface BookService {

	Result add(BookDto book);
	
	Result update (Book book);
	
	Result delete(int id);
	
	
	DataResult<Book> getById(int bookId);
	
	DataResult<Book> getByName(String name);
	
	DataResult<List<Book>> getAll();
	
	DataResult<List<Book>>  getByAuthor_id(int authorId);
	
	//List<Book> findByNameOrderName(String name);
	
	DataResult<List<Book>>  getByPublisher_id(int publisherId);
	
	DataResult<List<Book>> getByCategory_Id(int categoryId);

	
	
}
