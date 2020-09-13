package com.ingecno.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ingecno.model.Users;
import com.ingecno.repository.UserRepository;
import com.ingecno.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public List<Users> getAllUsers() {
		System.err.println("in user repo....");
		return userRepo.findAll();
	}

	@Override
	public Users getUserById(Long id) {
		Optional<Users> opt=userRepo.findById(id);
		Users u=opt.get();
		return u;
	}

	@Override
	public Users addUsers(Users user) {
		Users u=new Users();
		u.setRoleId(user.getRoleId());
		u.setUserName(user.getUserName());
		u.setPassword(user.getPassword());
		u.setRole(user.getRole());
		
		return userRepo.save(u);
	}

	@Override
	public String deleteUser(Long id) {
		userRepo.deleteById(id);
		return "User deleted succesfully with id : "+id;
	}

}
