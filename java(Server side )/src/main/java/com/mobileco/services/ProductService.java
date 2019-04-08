package com.mobileco.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobileco.dao.ProductDAO;
import com.mobileco.exceptions.MobilecoException;
import com.mobileco.interfaces.IProductInterface;
import com.mobileco.model.Product;

@Service
public class ProductService implements IProductInterface {

	private ProductDAO productDao = new ProductDAO();
	
	@Override
	public List<Product> getAllProducts(String str) throws MobilecoException {
		// TODO Auto-generated method stub
		return productDao.getAllProducts(str);
	}

	@Override
	public List<Product> getAllMobiles() throws MobilecoException {
		// TODO Auto-generated method stub
		return productDao.getMobiles();
	}

	@Override
	public List<Product> getAllAccessories() throws MobilecoException {
		// TODO Auto-generated method stub
		return productDao.getAccesories();
	}
	
}
