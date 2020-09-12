package com.ingecno.service;

import java.util.List;

import com.ingecno.model.Address;

public interface AddressService {

	public List<Address> getAllAddresses();

	public Address getAddressById(Long id);

	public Address addAddress(Address address);

	public String deleteAddress(Long id);

}
