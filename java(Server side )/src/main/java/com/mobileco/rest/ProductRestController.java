package com.mobileco.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mobileco.exceptions.MobilecoException;
import com.mobileco.model.Product;
import com.mobileco.services.ProductService;

@CrossOrigin // to make applications(Angular) running on other ports to access
				// this controller
@RestController // methods in rest controller returns object and not model and
				// view like in test controller.These methods can be directly
				// tested using postman
public class ProductRestController {

	@Autowired(required = true)
	private ProductService service;

	// to get all the products (both mobiles and acc) present in db
	@GetMapping("/items")
	public List<Product> getItem() {

		try {
			return service.getAllProducts(null);
		}

		catch (MobilecoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	// get all products on the basis of search param by user
	@GetMapping("/items/{str}")
	public List<Product> getAllItems(@PathVariable String str) {

		try {
			return service.getAllProducts(str);
		}

		catch (MobilecoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	// get all mobile items
	@GetMapping("/items/mobile")
	public List<Product> getAllMobiles() {
		try {
			return service.getAllMobiles();
		} catch (MobilecoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	// get all accessories items
	@GetMapping("/items/acc")
	public List<Product> getAllAccessories() {
		try {
			return service.getAllAccessories();
		} catch (MobilecoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
