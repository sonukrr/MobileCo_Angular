package com.mobileco.interfaces;

import com.mobileco.exceptions.MobilecoException;
import com.mobileco.model.Customer;

public interface ICustomer {

	public int registerCustomer(Customer customer) throws MobilecoException;
	public Customer getCustomerById(int id) throws MobilecoException;
	public void updateCustomer(Customer customer) throws MobilecoException;
	public Customer loginCheck(Customer customer);
}
