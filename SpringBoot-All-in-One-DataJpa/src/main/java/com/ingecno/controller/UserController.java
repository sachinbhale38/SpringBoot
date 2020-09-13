package com.ingecno.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ingecno.model.Role;
import com.ingecno.model.Users;
import com.ingecno.repository.RoleRepository;
import com.ingecno.service.UserService;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private RoleRepository roleRepository;

	// get all users
	@GetMapping
	public List<Users> getAllUsers() {
		return userService.getAllUsers();

	}

	// get user by id
	@GetMapping(path = "/{id}")
	public Users getUserById(@PathVariable("id") Long id) {
		return userService.getUserById(id);

	}

	// add new users
	@PostMapping
	public Users addUsers(@RequestBody Users user) {
		System.err.println("in post mapping...");
		System.err.println(user.getRoleId());
		Role r= roleRepository.findById(user.getRoleId()).get();
		System.err.println(r);
		user.setRole(r);
		return userService.addUsers(user);

	}

	// delete one users
	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable("id") Long id) {
		System.err.println("in delete mapping...");
		return userService.deleteUser(id);

	}

}
