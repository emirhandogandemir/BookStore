package com.bookstore.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.business.abstracts.CartService;
import com.bookstore.business.abstracts.UserService;
import com.bookstore.config.jwt.TokenProvider;
import com.bookstore.core.entities.AuthToken;
import com.bookstore.core.entities.User;
import com.bookstore.core.entities.dtos.UserLoginDto;
import com.bookstore.core.entities.dtos.UserRegisterDto;
import com.bookstore.core.utilities.mail.springmail.EmailSenderImpl;
import com.bookstore.core.utilities.mail.springmail.EmailSenderService;
import com.bookstore.domain.dtos.CartDto;

@RestController
@RequestMapping("/api/auth/")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AuthController {
	
	@Value("${email.content}")
	public String EMAIL_CONTENT;
	
	@Autowired
	private  CartService cartService;
	
	@Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenProvider jwtTokenUtil;

    @Autowired
    private UserService userService;
    
    @Autowired
    private EmailSenderService emailSenderService;
    
	
    
    @PostMapping("/login")
    public ResponseEntity<?> generateToken(@RequestBody UserLoginDto loginUser) throws AuthenticationException {

        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUser.getUsername(),
                        loginUser.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = jwtTokenUtil.generateToken(authentication);
        return ResponseEntity.ok(new AuthToken(token));
    }
    @RequestMapping(value="/register", method = RequestMethod.POST)
    public User saveUser(@RequestBody UserRegisterDto user){
   
    	emailSenderService.sendSimpleEmail(user.getEmail(), EMAIL_CONTENT, "BookStore Sistem Kayıtı");
        return userService.save(user);
    }



    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value="/adminping", method = RequestMethod.GET)
    public String adminPing(){
        return "Only Admins Can Read This";
    }

    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value="/userping", method = RequestMethod.GET)
    public String userPing(){
        return "Any User Can Read This";
    }
    @PreAuthorize("hasRole('SUPER_ADMIN')")
    @RequestMapping(value="/superping", method = RequestMethod.GET)
    public String superPing(){
        return "Any SUPER_ADMIN Can Read This";
    }
    
}
