package com.mobileco.interfaces;

//Author: Abhishek Kumar

import java.util.List;

import com.mobileco.exceptions.MobilecoException;
import com.mobileco.model.Product;

public interface IProductInterface {
	public List<Product> getAllProducts(String str) throws MobilecoException;
	public List<Product> getAllMobiles() throws MobilecoException;
	public List<Product> getAllAccessories() throws MobilecoException;
}
