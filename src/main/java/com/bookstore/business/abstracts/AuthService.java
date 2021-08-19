package com.bookstore.business.abstracts;

import com.bookstore.business.security.AccessToken;
import com.bookstore.core.entities.dtos.UserLoginDto;
import com.bookstore.core.entities.dtos.UserRegisterDto;

public interface AuthService {

	
 AccessToken register(UserRegisterDto userRegisterDto);
	
	AccessToken login(UserLoginDto userLoginDto);
}
