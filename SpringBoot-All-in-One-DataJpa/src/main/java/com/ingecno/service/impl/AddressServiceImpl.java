package com.ingecno.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ingecno.model.Address;
import com.ingecno.repository.AddressRepository;
import com.ingecno.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {
	
	@Autowired
	private AddressRepository addressRepository;

	@Override
	public List<Address> getAllAddresses() {
		// TODO Auto-generated method stub
		return addressRepository.findAll();
	}

	@Override
	public Address getAddressById(Long id) {
		Optional<Address>  opt=addressRepository.findById(id);
		Address a=opt.get();
		return a;
	}

	@Override
	public Address addAddress(Address address) {
		// TODO Auto-generated method stub
		return addressRepository.save(address);
	}

	@Override
	public String deleteAddress(Long id) {
		addressRepository.deleteById(id);
		return "Address deleted succesfully with id : "+id;
	}

}
