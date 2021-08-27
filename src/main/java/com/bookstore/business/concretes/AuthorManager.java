package com.bookstore.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.business.abstracts.AuthorService;
import com.bookstore.business.constants.Messages;
import com.bookstore.core.utilities.results.DataResult;
import com.bookstore.core.utilities.results.Result;
import com.bookstore.core.utilities.results.SuccessDataResult;
import com.bookstore.core.utilities.results.SuccessResult;
import com.bookstore.domain.Author;
import com.bookstore.domain.dtos.AuthorDto;
import com.bookstore.domain.mapper.AuthorMapper;
import com.bookstore.repository.AuthorRepository;

@Service
public class AuthorManager implements AuthorService {

	private final AuthorRepository authorRepository;
	
	private final AuthorMapper authorMapper;
	
	public AuthorManager(AuthorRepository authorRepository,AuthorMapper authorMapper) {
		
		this.authorRepository = authorRepository;
		this.authorMapper=authorMapper;
	}

	@Override
	public Result add(AuthorDto author) {
	this.authorRepository.save(authorMapper.dtoToModel(author));
	return new SuccessResult(Messages.authorAdded);
	}

	@Override
	public Result update(AuthorDto author) {
		this.authorRepository.save(authorMapper.dtoToModel(author));
		return new SuccessResult(Messages.authorUpdated);
	}

	@Override
	public Result delete(int id) {
		this.authorRepository.deleteById(id);
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

	@Override
	public DataResult<List<Author>> getAll() {
		return new SuccessDataResult<List<Author>>(this.authorRepository.findAll());
	}

}
