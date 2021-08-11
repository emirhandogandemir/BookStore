package com.bookstore.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.bookstore.business.abstracts.AdminService;
import com.bookstore.business.constants.Messages;
import com.bookstore.core.utilities.results.DataResult;
import com.bookstore.core.utilities.results.Result;
import com.bookstore.core.utilities.results.SuccessDataResult;
import com.bookstore.core.utilities.results.SuccessResult;
import com.bookstore.domain.Admin;
import com.bookstore.repository.AdminRepository;

@Service
@Primary
public class AdminManager implements AdminService{

	private final AdminRepository adminRepository;
	
	
	
	public AdminManager(AdminRepository adminRepository) {
		
		this.adminRepository = adminRepository;
	}

	@Override
	public Result add(Admin admin) {
		this.adminRepository.save(admin);
		return new SuccessResult(Messages.adminAdded);
	}

	@Override
	public Result update(Admin admin) {
		this.adminRepository.save(admin);
		return new SuccessResult(Messages.adminUpdated);
	}

	@Override
	public Result delete(int id) {
		this.adminRepository.deleteById(id);
		return new SuccessResult(Messages.adminDeleted);
	}

	@Override
	public DataResult<Admin> getById(int id) {
		return new SuccessDataResult<Admin>(this.adminRepository.getById(id));
	}

	@Override
	public DataResult<Admin> getByFirstName(String firstName) {
		return new SuccessDataResult<Admin>(this.adminRepository.getByFirstName(firstName));
	}

	@Override
	public DataResult<Admin> getByLastName(String lastName) {
		return new SuccessDataResult<Admin>(this.adminRepository.getByLastName(lastName));
		}
	}


