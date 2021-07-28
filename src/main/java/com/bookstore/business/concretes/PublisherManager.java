package com.bookstore.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.business.abstracts.PublisherService;
import com.bookstore.business.constants.Messages;
import com.bookstore.core.utilities.results.DataResult;
import com.bookstore.core.utilities.results.Result;
import com.bookstore.core.utilities.results.SuccessDataResult;
import com.bookstore.core.utilities.results.SuccessResult;
import com.bookstore.domain.Publisher;
import com.bookstore.repository.PublisherRepository;

@Service
public class PublisherManager implements PublisherService{

	private PublisherRepository publisherRepository;
	
	@Autowired
	public PublisherManager(PublisherRepository publisherRepository) {
		super();
		this.publisherRepository = publisherRepository;
	}

	@Override
	public Result add(Publisher publisher) {
		this.publisherRepository.save(publisher);
		return new SuccessResult(Messages.publisherAdded);
	}

	@Override
	public Result update(Publisher publisher) {
		this.publisherRepository.save(publisher);
		return new SuccessResult(Messages.publisherUpdated);
	}

	@Override
	public Result delete(int id) {
	this.publisherRepository.deleteById(id);
	return new SuccessResult(Messages.publisherDeleted);
	}

	@Override
	public DataResult<Publisher> getById(int id) {
	return new SuccessDataResult<Publisher>(this.publisherRepository.getById(id));
	}

	@Override
	public DataResult<Publisher> getByName(String name) {
		return new SuccessDataResult<Publisher>(this.publisherRepository.getByName(name));
	}

	@Override
	public DataResult<List<Publisher>> getAll() {
	return new SuccessDataResult<List<Publisher>>(this.publisherRepository.findAll());
	}

}
