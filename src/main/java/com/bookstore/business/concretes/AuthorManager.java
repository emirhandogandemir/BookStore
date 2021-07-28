package com.bookstore.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.business.abstracts.AuthorService;
import com.bookstore.business.constants.Messages;
import com.bookstore.core.utilities.results.DataResult;
import com.bookstore.core.utilities.results.Result;
import com.bookstore.core.utilities.results.SuccessDataResult;
import com.bookstore.core.utilities.results.SuccessResult;
import com.bookstore.domain.Author;
import com.bookstore.repository.AuthorRepository;

@Service
public class AuthorManager implements AuthorService {

	private AuthorRepository authorRepository;
	
	@Autowired
	public AuthorManager(AuthorRepository authorRepository) {
		super();
		this.authorRepository = authorRepository;
	}

	@Override
	public Result add(Author author) {
	this.authorRepository.save(author);
	return new SuccessResult(Messages.authorAdded);
	}

	@Override
	public Result update(Author author) {
		this.authorRepository.save(author);
		return new SuccessResult(Messages.authorUpdated);
	}

	@Override
	public Result delete(int id) {
		this.authorRepository.deleteById(null);
		return new SuccessResult(Messages.authorDeleted);
	}

	@Override
	public DataResult<Author> getById(int id) {
		return new SuccessDataResult<Author>(this.authorRepository.getById(id));
	}

	@Override
	public DataResult<Author> getByFirstName(String firstName) {
		return new SuccessDataResult<Author>(this.authorRepository.getByFirstName(firstName));
	}

	@Override
	public DataResult<Author> getByLastName(String lastName) {
		return new SuccessDataResult<Author>(this.authorRepository.getByLastName(lastName));
	}

}
