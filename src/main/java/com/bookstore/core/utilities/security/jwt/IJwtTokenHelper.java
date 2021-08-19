package com.bookstore.core.utilities.security.jwt;

import java.util.Set;

import com.bookstore.core.entities.Role;
import com.bookstore.core.utilities.security.AccessToken;
import com.bookstore.core.utilities.security.SecretKey;

public interface IJwtTokenHelper {
	String generateJwtToken(SecretKey secretKey, String username, Set<Role> roles);// Bir tane token oluşturacağımız
																					// yapıdır

	boolean validateJwtToken(SecretKey secretKey, AccessToken accessToken); // bu tokenı doğrulama işlemlerini
																			// yapacağımız method

	String getUsernameFromJwtToken(SecretKey secretKey, AccessToken accessToken);// jwt tokenden subject ile usernamei
																					// almak
}
