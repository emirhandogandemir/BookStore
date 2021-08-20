package com.bookstore.business.concretes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bookstore.business.abstracts.RoleService;
import com.bookstore.business.abstracts.UserService;
import com.bookstore.business.constants.Messages;
import com.bookstore.core.entities.Role;
import com.bookstore.core.entities.User;
import com.bookstore.core.entities.dtos.UserLoginDto;
import com.bookstore.core.entities.dtos.UserRegisterDto;
import com.bookstore.core.repository.UserRepository;
import com.bookstore.core.utilities.results.DataResult;
import com.bookstore.core.utilities.results.Result;
import com.bookstore.core.utilities.results.SuccessDataResult;
import com.bookstore.core.utilities.results.SuccessResult;

@Service(value = "userService")
public class UserManager implements UserService ,UserDetailsService{

	private final UserRepository userRepository;
	
	 @Resource(name = "roleService")
	private final RoleService roleService;
	
	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;

	public UserManager(UserRepository userRepository,RoleService roleService) {

		this.roleService=roleService;
		this.userRepository = userRepository;
	}

	   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	        User user = userRepository.findByUsername(username);
	        if(user == null){
	            throw new UsernameNotFoundException("Invalid username or password.");
	        }
	        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority(user));
	    }

	    private Set<SimpleGrantedAuthority> getAuthority(User user) {
	        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
	        user.getRoles().forEach(role -> {
	            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
	        });
	        return authorities;
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

	@Override
	public User save(UserRegisterDto user) {

		User nUser = user.getUserFromDto();
		nUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		
		 Role role = roleService.findByName("USER");
		 Set<Role> roleSet = new HashSet<>();
		 roleSet.add(role);
		if(nUser.getEmail().split("@")[1].equals("admin.edu")) {
			role = roleService.findByName("ADMIN");
			roleSet.add(role);
		}
		nUser.setRoles(roleSet);
		return userRepository.save(nUser);
	}

	@Override
	public List<User> findAll() {
		  List<User> list = new ArrayList<>();
	        userRepository.findAll().iterator().forEachRemaining(list::add);
	        return list;
	}

	@Override
	public User findOne(String username) {
		return userRepository.findByUsername(username);
	}

	

 

	
	

}
