package com.bookstore.business.abstracts;

import java.util.List;

import com.bookstore.core.utilities.results.DataResult;
import com.bookstore.core.utilities.results.Result;
import com.bookstore.domain.Author;
import com.bookstore.domain.dtos.AuthorDto;

public interface AuthorService {

	Result add(AuthorDto authorDto);
	
	Result update(AuthorDto authorDto);
	
	Result delete(int id);
	
	DataResult<Author> getById(int id);
	
	DataResult<Author> getByFirstName(String firstName);

	DataResult<Author> getByLastName(String lastName);
	
	DataResult<List<Author>> getAll();
	
}
