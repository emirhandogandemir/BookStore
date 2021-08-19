package com.bookstore.core.utilities.security;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;

import com.bookstore.core.entities.Role;

public interface ITokenProvider {

	AccessToken createToken(String username, Set<Role> roles); // token

	boolean validateToken(AccessToken accessToken);

	AccessToken getTokenFromHeader(HttpServletRequest httpServletRequest); // Başlıktan tokenı alıp kontrol etme bearere
																			// göre

	Authentication getAuthentication(AccessToken accessToken);

}
