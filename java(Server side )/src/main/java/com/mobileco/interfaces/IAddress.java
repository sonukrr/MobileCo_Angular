package com.mobileco.interfaces;

import java.sql.Connection;

import com.mobileco.exceptions.MobilecoException;
import com.mobileco.model.Address;

public interface IAddress {

	public int registerAddress(Connection connObj,Address address) throws MobilecoException;
	public void updateAddress(Connection connObj,Address address) throws MobilecoException;
	public Address getAddressById(Connection connObj,int id) throws MobilecoException;
	
	
}
