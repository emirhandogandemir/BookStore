package com.bookstore.business.concretes;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookstore.business.abstracts.AuthService;
import com.bookstore.core.aspects.exception.CustomSecurityException;
import com.bookstore.core.entities.Role;
import com.bookstore.core.entities.User;
import com.bookstore.core.entities.dtos.UserLoginDto;
import com.bookstore.core.entities.dtos.UserRegisterDto;
import com.bookstore.core.repository.RoleRepository;
import com.bookstore.core.repository.UserRepository;
import com.bookstore.core.utilities.constants.ApiMessages;
import com.bookstore.core.utilities.security.AccessToken;
import com.bookstore.core.utilities.security.ITokenProvider;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional
public class AuthManager implements AuthService {

	@Autowired
	private ITokenProvider tokenProvider;

	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Override
	public AccessToken register(UserRegisterDto userRegisterDto) {
		checkUserExistsWithUserName(userRegisterDto.getUsername());

		User user = new User();
		user.setEmail(userRegisterDto.getEmail());
		user.setUsername(userRegisterDto.getUsername());
		user.setPassword(passwordEncoder.encode(userRegisterDto.getPassword()));
		user.setRoles(getRoles(userRegisterDto.getRoles()));

		userRepository.save(user);

		String username = user.getUsername();
		Set<Role> roles = user.getRoles();

		return tokenProvider.createToken(username, roles);
	}

	@Override
	public AccessToken login(UserLoginDto userLoginDto) {
		String username = userLoginDto.getUsername();
        String password = userLoginDto.getPassword();
        try {
           
        	Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
            Set<Role> roles = userRepository.findByUsername(username).get().getRoles();
            return tokenProvider.createToken(username,roles);

        }catch (AuthenticationException exception) {
            throw new CustomSecurityException(ApiMessages.BAD_CREDENTIALS, HttpStatus.BAD_REQUEST);

        }
	}

	private void checkUserExistsWithUserName(String username) {
		if (userRepository.existsByUsername(username)) {
			throw new CustomSecurityException(ApiMessages.USER_ALREADY_EXISTS, HttpStatus.BAD_REQUEST);
		}
	}

	private Set<Role> getRoles(String[] roles) {
		Set<Role> userRoles = new HashSet<>();
		for (String role : roles) {
			userRoles.add(roleRepository.findByName(role));
		}
		return userRoles;
	}
}
