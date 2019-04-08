package com.mobileco.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mobileco.dao.CartDAO;
import com.mobileco.exceptions.MobilecoException;
import com.mobileco.interfaces.ICart;
import com.mobileco.model.Cart;
import com.mobileco.model.Customer;
import com.mobileco.model.Product;

@Service
public class CartService implements ICart {

	private CartDAO cartDao=new CartDAO();
	
	@Override
	public List<Cart> addToCart(Customer customer, Product product) throws MobilecoException {
		// TODO Auto-generated method stub
		return cartDao.addToCart(customer, product);
	}

	@Override
	public List<Cart> removeFromCart(Cart cart) throws MobilecoException {
		// TODO Auto-generated method stub
		return cartDao.removeFromCart(cart);
	}

	@Override
	public List<Cart> getItemsInCart(Customer customer) throws MobilecoException {
		// TODO Auto-generated method stub
		return cartDao.getItemsInCart(customer);
	}

	@Override
	public List<Cart> updateCartQuantity(Cart cart) throws MobilecoException {
		// TODO Auto-generated method stub
		return cartDao.updateCartQuantity(cart);
	}

}
