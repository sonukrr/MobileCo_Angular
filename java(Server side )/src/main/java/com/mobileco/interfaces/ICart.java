package com.mobileco.interfaces;

import java.util.List;

import com.mobileco.exceptions.MobilecoException;
import com.mobileco.model.Cart;
import com.mobileco.model.Customer;
import com.mobileco.model.Product;

public interface ICart {

	public List<Cart> addToCart(Customer customer,Product product) throws MobilecoException;
	public List<Cart> removeFromCart(Cart cart) throws MobilecoException;
	public List<Cart> getItemsInCart(Customer customer) throws MobilecoException;
	public List<Cart> updateCartQuantity(Cart cart) throws MobilecoException;
	
}
