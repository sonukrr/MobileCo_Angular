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
import com.mobileco.model.Orders;
import com.mobileco.services.CustomerService;
import com.mobileco.services.OrdersService;

@CrossOrigin			//to make applications(Angular) running on other ports to access this controller
@RestController			//methods in rest controller returns object and not model and view like in test controller.These methods can be directly tested using postman
public class OrdersRestController {

	@Autowired
	private OrdersService ordersService;

	@Autowired
	private CustomerService custService;

	public OrdersRestController() {
		// TODO Auto-generated constructor stub
	}

	//get all orders of customer using his id
	@GetMapping("/orders/all/{id}")
	public List<Orders> getAllOrders(@PathVariable int id) {
		// System.out.println("---------here---------------"+id);
		Customer customer = new Customer();
		customer.setId(id);
		System.out.println("customer----------->" + customer);

		return ordersService.getAllOrders(customer);

	}

	//check for any pending orders of currently logged in user
	@GetMapping("/orders/pending")
	public List<Orders> getPendingOrders(HttpSession session) {
		Customer customer = (Customer) session.getAttribute("login-user");
		System.out.println(customer);
		return ordersService.getPendingOrders(customer);
	}
	
	//to place order by emptying cart and moving cart items to orders table
	@PostMapping("/placeorder")
	public CartResponseModel placeOrder(@RequestBody List<Cart> cartList) {

		if (cartList.size() <= 0) {
			return new CartResponseModel("Cart list is already empty!First add items to cart", null);
		}

		else {
			Customer customer = cartList.get(0).getCustomer();
			if (customer == null)
				return new CartResponseModel("Please login to continue", null);
			else {
				try {
					ordersService.placeOrder(cartList, customer);
					return new CartResponseModel("Your order has been placed successfully", null);
				} catch (MobilecoException e) {
					// TODO Auto-generated catch block

					e.printStackTrace();
				}
			}
		}
		return null;
	}
}
