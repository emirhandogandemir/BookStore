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
import com.bookstore.domain.dtos.PublisherDto;
import com.bookstore.domain.mapper.PublisherMapper;
import com.bookstore.repository.PublisherRepository;

@Service
public class PublisherManager implements PublisherService{

	private final PublisherRepository publisherRepository;
	private final PublisherMapper publisherMapper;
	

	public PublisherManager(PublisherRepository publisherRepository,PublisherMapper publisherMapper) {
		
		this.publisherRepository = publisherRepository;
		this.publisherMapper=publisherMapper;
	}

	@Override
	public Result add(PublisherDto publisherDto) {
		this.publisherRepository.save(publisherMapper.dtoToModel(publisherDto));
		return new SuccessResult(Messages.publisherAdded);
	}

	@Override
	public Result update(PublisherDto publisherDto) {
		this.publisherRepository.save(publisherMapper.dtoToModel(publisherDto));
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
