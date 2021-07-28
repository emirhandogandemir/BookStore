package com.bookstore.business.abstracts;

import com.bookstore.core.utilities.results.DataResult;
import com.bookstore.core.utilities.results.Result;
import com.bookstore.domain.Author;

public interface AuthorService {

	Result add(Author author);
	
	Result update(Author author);
	
	Result delete(int id);
	
	DataResult<Author> getById(int id);
	
	DataResult<Author> getByFirstName(String firstName);

	DataResult<Author> getByLastName(String lastName);
	
}
