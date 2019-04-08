package com.mobileco.rest;

import java.sql.Connection;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mobileco.exceptions.MobilecoException;
import com.mobileco.model.Customer;
import com.mobileco.services.AddressService;
import com.mobileco.services.CustomerService;
import com.mobileco.util.ConnectionUtil;
import com.mobileco.util.SecurePassword;

@CrossOrigin     	//to make applications(Angular) running on other ports to access this controller 
@RestController		//methods in rest controller returns object and not model and view like in test controller.These methods can be directly tested using postman
public class CustomerRestController {

	@Autowired(required = true)
	private CustomerService customerService;

	@Autowired(required = true)
	private AddressService addressService;

	//to login customer and authenticate 
	@PostMapping("/loginCustomer")
	public Customer login(@RequestBody Customer customer, HttpSession session) {
		System.out.println("inside login ckheck ");

		customer.setPassword(SecurePassword.encrypt(customer.getPassword()));

		Customer loggedCustomer = customerService.loginCheck(customer);

		if (loggedCustomer != null) {
			return loggedCustomer;
		}

		else
			return new Customer();
	}

	//to update address of customer 
	@PostMapping("/updateAddress")
	public Customer updateAddress(@RequestBody Customer customer) {
		Connection connObj;
		try {

			connObj = ConnectionUtil.getConnection();
			addressService.updateAddress(connObj, customer.getAddress());

		} catch (MobilecoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

}
