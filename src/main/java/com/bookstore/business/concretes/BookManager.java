package com.bookstore.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.business.abstracts.BookService;
import com.bookstore.business.constants.Messages;
import com.bookstore.core.utilities.results.DataResult;
import com.bookstore.core.utilities.results.Result;
import com.bookstore.core.utilities.results.SuccessDataResult;
import com.bookstore.core.utilities.results.SuccessResult;
import com.bookstore.domain.Book;
import com.bookstore.repository.BookRepository;

@Service
public class BookManager implements BookService {

	private BookRepository bookRepository;
	
	
	@Autowired
	public BookManager(BookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}

	@Override
	public Result add(Book book) {
		this.bookRepository.save(book);
		return new SuccessResult(Messages.bookAdded);
		
	}

	@Override
	public Result update(Book book) {
		this.bookRepository.save(book);
		return new SuccessResult(Messages.bookUpdated);
	}

	@Override
	public Result delete(int id) {
		this.bookRepository.deleteById(id);
		return new SuccessResult(Messages.bookDeleted);
	}

	@Override
	public DataResult<Book> getById(int bookId) {
		return new SuccessDataResult<Book>(this.bookRepository.getById(bookId));
	}

	@Override
	public DataResult<Book> getByName(String name) {
		return new SuccessDataResult<Book>(this.bookRepository.getByName(name));
	}

	@Override
	public DataResult<List<Book>> getByAuthor_id(int authorId) {
		return new SuccessDataResult<List<Book>>(this.bookRepository.getByAuthor_id(authorId));
	}

	@Override
	public DataResult<List<Book>> getByPublisher_id(int publisherId) {
		return new SuccessDataResult<List<Book>>(this.bookRepository.getByPublisher_id(publisherId));
	}

	@Override
	public DataResult<List<Book>> getByCategory_Id(int categoryId) {
		return new SuccessDataResult<List<Book>>(this.bookRepository.getByCategory_Id(categoryId));
	}

	@Override
	public DataResult<List<Book>> getAll() {
		return new SuccessDataResult<List<Book>>(this.bookRepository.findAll());
	}

}
