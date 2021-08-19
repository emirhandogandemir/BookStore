package com.bookstore.business.abstracts;


import com.bookstore.core.entities.dtos.UserLoginDto;
import com.bookstore.core.entities.dtos.UserRegisterDto;
import com.bookstore.core.utilities.security.AccessToken;

public interface AuthService {

	AccessToken register(UserRegisterDto userRegisterDto);

	AccessToken login(UserLoginDto userLoginDto);
}
