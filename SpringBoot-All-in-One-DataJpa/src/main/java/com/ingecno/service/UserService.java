package com.ingecno.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ingecno.model.Users;

public interface UserService {

	public List<Users> getAllUsers();

	public Users getUserById(Long id);

	public Users addUsers(Users user);

	public String deleteUser(Long id);

}
