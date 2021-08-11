package com.bookstore.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.business.abstracts.UserService;
import com.bookstore.business.constants.Messages;
import com.bookstore.core.entities.User;
import com.bookstore.core.repository.UserRepository;
import com.bookstore.core.utilities.results.DataResult;
import com.bookstore.core.utilities.results.Result;
import com.bookstore.core.utilities.results.SuccessDataResult;
import com.bookstore.core.utilities.results.SuccessResult;

@Service
public class UserManager implements UserService {

	private final UserRepository userRepository;

	public UserManager(UserRepository userRepository) {

		this.userRepository = userRepository;
	}

	@Override
	public Result add(User user) {
		this.userRepository.save(user);
		return new SuccessResult(Messages.userAdded);
	}

	@Override
	public Result update(User user) {
		this.userRepository.save(user);
		return new SuccessResult(Messages.userUpdated);
	}

	@Override
	public Result delete(int id) {
		this.userRepository.deleteById(id);
		return new SuccessResult(Messages.userDeleted);
	}

	@Override
	public DataResult<User> getById(int id) {
		return new SuccessDataResult<User>(this.userRepository.getById(id));
	}

	@Override
	public DataResult<List<User>> getAll() {
		return new SuccessDataResult<List<User>>(this.userRepository.findAll());
	}

	@Override
	public DataResult<User> getUserByEmail(String email) {
		return new SuccessDataResult<User>(this.userRepository.getByEmail(email));
	}

}
