package com.ingecno.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ingecno.model.Address;
import com.ingecno.service.AddressService;
import com.ingecno.service.UserService;

@RestController
@RequestMapping("/api/v2/address")
public class AddresController {
	
	@Autowired
	private AddressService AddressService;
	
	@Autowired
	private UserService userService;
	

	// get all address
	@GetMapping
	public List<Address> getAllAddress() {
		return AddressService.getAllAddresses();

	}

	// get address by id
	@GetMapping(path = "/{id}")
	public Address getAddressById(@PathVariable("id") Long id) {
		System.err.println("in getbyId mapping...");
		return AddressService.getAddressById(id);

	}

	// add new address
	@PostMapping
	public Address addAddress(@RequestBody Address address) {
		address.setUser(userService.getUserById(address.getUserId()));
		return AddressService.addAddress(address);

	}

	// delete one address
	@RequestMapping("/{id}")
	public String deleteAddress(@PathVariable("id") Long id) {
		System.err.println("in delete mapping...");
		return AddressService.deleteAddress(id);

	}


}
