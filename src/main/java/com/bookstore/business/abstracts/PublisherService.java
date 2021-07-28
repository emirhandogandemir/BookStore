package com.bookstore.business.abstracts;

import java.util.List;

import com.bookstore.core.utilities.results.DataResult;
import com.bookstore.core.utilities.results.Result;
import com.bookstore.domain.Publisher;

public interface PublisherService {

	Result add(Publisher publisher);
	
	Result update(Publisher publisher);
	
	Result delete(int id);
	
	DataResult<Publisher>  getById(int id);
	
	DataResult<Publisher>  getByName(String name);
	
	DataResult<List<Publisher>> getAll();
	
}
