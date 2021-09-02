package com.bookstore.business.concretes;

import java.util.List;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.bookstore.business.abstracts.BookCardService;
import com.bookstore.domain.Book;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Service
public class BookCardManager implements BookCardService {

	private final JdbcTemplate jdbcTemplate;

	public BookCardManager(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void addAllBookCart(int cartId, int bookId) {
		jdbcTemplate.update("insert into cart_books(cart_id, book_id) values (?,?)",cartId,bookId);
				

		

	}

	@Override
	public void deleteByBookId(Long bookId) {
		String deleteQuery = "delete from cart_books where book_id= ?";
		jdbcTemplate.update(deleteQuery, bookId);

	}

}
