package com.bookstore.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.bookstore.core.aspects.exception.CustomSecurityException;
import com.bookstore.core.utilities.security.AccessToken;
import com.bookstore.core.utilities.security.ITokenProvider;

@Component
public class TokenFilter extends OncePerRequestFilter{

	@Autowired
	private ITokenProvider tokenProvider;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		 AccessToken accessToken = tokenProvider.getTokenFromHeader(request);
	        try {
	            if (checkAccessToken(accessToken)) {
	                Authentication authentication = tokenProvider.getAuthentication(accessToken);
	                SecurityContextHolder.getContext().setAuthentication(authentication);
	            }
	            filterChain.doFilter(request,response);
	        }
	        // Catch CustomSecurityException Before Global Exception Handler for clearing Context
	        catch (CustomSecurityException customSecurityException) {
	            SecurityContextHolder.clearContext();
	            // throw again
	            throw customSecurityException;
	        }
		
	}

	
	 private boolean checkAccessToken(AccessToken accessToken) {
	        if (accessToken == null) return false;
	        return tokenProvider.validateToken(accessToken);
	    }
}
