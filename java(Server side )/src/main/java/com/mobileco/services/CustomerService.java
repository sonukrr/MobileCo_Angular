package com.mobileco.services;

import org.springframework.stereotype.Service;

import com.mobileco.dao.CustomerDAO;
import com.mobileco.exceptions.MobilecoException;
import com.mobileco.interfaces.ICustomer;
import com.mobileco.model.Customer;

@Service
public class CustomerService implements ICustomer {

	
	private CustomerDAO customerDao = new CustomerDAO();
	


	@Override
	public int registerCustomer(Customer customer) throws MobilecoException {
		// TODO Auto-generated method stub
		return customerDao.registerCustomer(customer);
	}

	@Override
	public Customer getCustomerById(int id) throws MobilecoException {
		// TODO Auto-generated method stub
		return customerDao.getCustomerById(id);
	}

	@Override
	public void updateCustomer(Customer customer) throws MobilecoException {
		// TODO Auto-generated method stub
		customerDao.updateCustomer(customer);
	}

	@Override
	public Customer loginCheck(Customer customer) {
		// TODO Auto-generated method stub
		return customerDao.loginCheck(customer);
	}



}
