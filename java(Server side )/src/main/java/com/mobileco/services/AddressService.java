package com.mobileco.services;

import java.sql.Connection;

import org.springframework.stereotype.Service;

import com.mobileco.dao.AddressDAO;
import com.mobileco.exceptions.MobilecoException;
import com.mobileco.interfaces.IAddress;
import com.mobileco.model.Address;

@Service
public class AddressService implements IAddress {

	
	private AddressDAO addressDao = new AddressDAO();
	
	@Override
	public int registerAddress(Connection connObj, Address address) throws MobilecoException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateAddress(Connection connObj, Address address) throws MobilecoException {
		// TODO Auto-generated method stub
		addressDao.updateAddress(connObj, address);
	}

	@Override
	public Address getAddressById(Connection connObj, int id) throws MobilecoException {
		// TODO Auto-generated method stub
		return null;
	}

}
