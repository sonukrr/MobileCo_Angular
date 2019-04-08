package com.mobileco.interfaces;

import java.util.List;

import com.mobileco.exceptions.MobilecoException;
import com.mobileco.model.Cart;
import com.mobileco.model.Customer;
import com.mobileco.model.Orders;

public interface IOrders {

	public List<Orders> getAllOrders(Customer customer);
	public List<Orders> getPendingOrders(Customer customer);
	public void placeOrder(List<Cart> cartItems, Customer customer) throws MobilecoException;
}
