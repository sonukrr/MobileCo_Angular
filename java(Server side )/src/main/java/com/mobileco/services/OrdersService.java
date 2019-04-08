package com.mobileco.services;

import java.util.List;

import com.mobileco.dao.OrdersDAO;
import com.mobileco.exceptions.MobilecoException;
import com.mobileco.interfaces.IOrders;
import com.mobileco.model.Cart;
import com.mobileco.model.Customer;
import com.mobileco.model.Orders;

public class OrdersService implements IOrders {

	private OrdersDAO ordersDao=null;
	public OrdersService() {
		// TODO Auto-generated constructor stub
		ordersDao=new OrdersDAO();
	}

	@Override
	public List<Orders> getAllOrders(Customer customer) {
		// TODO Auto-generated method stub
		return ordersDao.getAllOrders(customer);
	}

	@Override
	public List<Orders> getPendingOrders(Customer customer) {
		// TODO Auto-generated method stub
		return ordersDao.getPendingOrders(customer);
	}

	@Override
	public void placeOrder(List<Cart> cartItems, Customer customer) throws MobilecoException {
		// TODO Auto-generated method stub
		ordersDao.placeOrder(cartItems, customer);
	}

}
