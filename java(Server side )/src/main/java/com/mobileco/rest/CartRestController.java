package com.mobileco.rest;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mobileco.exceptions.MobilecoException;
import com.mobileco.model.Cart;
import com.mobileco.model.CartResponseModel;
import com.mobileco.model.Customer;
import com.mobileco.services.CartService;
import com.mobileco.services.CustomerService;

@CrossOrigin			//to make applications(Angular) running on other ports to access this controller
@RestController			//methods in rest controller returns object and not model and view like in test controller.These methods can be directly tested using postman
public class CartRestController {

	@Autowired(required = true)
	private CartService cartService;
	
	//to add products in cart 
	@PostMapping("/addtocart")
	public CartResponseModel addtoCart(@RequestBody Cart cart, HttpSession session) {

		System.out.println("CART is ---->>" + cart);
		Customer customer = cart.getCustomer();
		System.out.println("REST: " + customer + " " + cart);
		if (customer == null) {
			return new CartResponseModel("Please Login to buy items.", null);
		}

		try {
			return new CartResponseModel("Item Added to cart :)", cartService.addToCart(customer, cart.getProduct()));
		} catch (MobilecoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new CartResponseModel(e.getMessage(), null);
		}

	}

	//to update cart object in Database e.g-quantity update
	@PostMapping("/updatecart")
	public CartResponseModel updateCart(@RequestBody Cart cart) {
		Customer customer = cart.getCustomer();
		System.out.println("REST UPDATE: " + customer + " " + cart);
		if (customer == null) {
			return new CartResponseModel("Please Login to buy items.", null);
		}
		cart.setCustomer(customer);

		try {
			int orderQuantity = cart.getOrderQuantity();
			int stockQuantity = cart.getProduct().getQuantity();

			if (orderQuantity <= 0)
				return new CartResponseModel("Quantity can't be less than or Zero.", null);

			if (orderQuantity > stockQuantity)
				return new CartResponseModel("You exceeded stock Quantity, you can only order max: " + stockQuantity
						+ " quantity for this item", null);

			return new CartResponseModel("Item successfully updated in the cart :)",
					cartService.updateCartQuantity(cart));
		} catch (MobilecoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new CartResponseModel(e.getMessage(), null);
		}
	}

	//to remove cart items i.e, product
	@PostMapping("/removecartitem")
	public CartResponseModel removeCartItem(@RequestBody Cart cart) {
		Customer customer = cart.getCustomer();
		System.out.println("REST UPDATE: " + customer + " " + cart);
		if (customer == null) {
			return new CartResponseModel("Please Login to buy items.", null);
		}
		cart.setCustomer(customer);
		try {
			return new CartResponseModel("Item successfully deleted from the cart", cartService.removeFromCart(cart));
		} catch (MobilecoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new CartResponseModel(e.getMessage(), null);
		}
	}

	//to fetch all products in cart using customer ID 
	@GetMapping("/cartitems/{id}")
	public List<Cart> getItemsInCart(@PathVariable int id) {

		Customer customer = new Customer();
		customer.setId(id);
		try {
			return cartService.getItemsInCart(customer);
		} catch (MobilecoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return null;
	}

}
