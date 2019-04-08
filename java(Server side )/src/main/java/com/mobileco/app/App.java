package com.mobileco.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import com.mobileco.controllers.CustomerController;

import com.mobileco.rest.OrdersRestController;
import com.mobileco.services.AddressService;
import com.mobileco.services.CartService;
import com.mobileco.services.CustomerService;
import com.mobileco.rest.CartRestController;
import com.mobileco.rest.CustomerRestController;
import com.mobileco.rest.ProductRestController;
import com.mobileco.services.OrdersService;
import com.mobileco.services.ProductService;

//main class from where spring boot application starts
@SpringBootApplication
public class App {

	public App() {
		// TODO Auto-generated constructor stub
	}

	// to load the test controller
	@Bean
	public CustomerController testController() {
		return new CustomerController();
	}

	@Bean
	public CustomerRestController getCustomerRest() {
		return new CustomerRestController();
	}

	@Bean
	public ProductRestController getProductRest() {
		return new ProductRestController();
	}

	@Bean
	public OrdersService getOrdersService() {
		return new OrdersService();
	}

	@Bean
	public OrdersRestController getOrdersRest() {
		return new OrdersRestController();
	}

	@Bean
	public ProductService getProductService() {
		return new ProductService();
	}

	@Bean
	public CartService getCartService() {
		return new CartService();
	}

	@Bean
	public CustomerService getCustomerService() {
		return new CustomerService();
	}

	@Bean
	public CartRestController getCartRestController() {
		return new CartRestController();
	}

	@Bean
	public AddressService addressService() {
		return new AddressService();
	}

	@Bean
	public UrlBasedViewResolver setUpViewResolver() {
		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(JstlView.class);

		return resolver;
	}

	public static void main(String[] args) {
		// the below static method run tells spring boot to run the spring
		// application from here
		SpringApplication.run(App.class, args);

	}
}
