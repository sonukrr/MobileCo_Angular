package com.mobileco.dao;

//Author: Abhishek Kumar

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mobileco.exceptions.MobilecoException;
import com.mobileco.model.Accessories;
import com.mobileco.model.Brand;
import com.mobileco.model.Mobile;
import com.mobileco.model.Product;
import com.mobileco.util.ConnectionUtil;

@Repository
public class ProductDAO {

	public ProductDAO() {
		// TODO Auto-generated constructor stub
	}

	// get list of products on basis of search parameter
	public List<Product> getAllProducts(String searchStr) throws MobilecoException {

		String query = "select * from product p " + "left join accessories a on a.id = p.accessories_id "
				+ "left join mobile m on m.id = p.mobile_id " + "join brand b on b.id = p.brand_id "
				+ "where a.name like '" + searchStr + "%' or m.name like '" + searchStr + "%' or " + "b.name like '"
				+ searchStr + "%' or m.ram = ? or m.rom = ? or m.fcamera=? or m.rcamera=?" + "order by p.quantity DESC";

		if (searchStr == null)
			query = "select * from product p " + "left join accessories a on a.id = p.accessories_id "
					+ "left join mobile m on m.id = p.mobile_id " + "join brand b on b.id = p.brand_id "
					+ "order by quantity DESC";

		Connection connection = null;
		PreparedStatement psmt = null;
		ResultSet resultSet = null;

		List<Product> list = new ArrayList<Product>();

		try {

			connection = ConnectionUtil.getConnection();
			psmt = connection.prepareStatement(query);
			if (searchStr != null) {
				psmt.setString(1, searchStr);
				psmt.setString(2, searchStr);
				psmt.setString(3, searchStr);
				psmt.setString(4, searchStr);
			}
			resultSet = psmt.executeQuery();

			while (resultSet.next()) {

				Product product = new Product();
				Object object = null;

				int productId = resultSet.getInt("p.id");
				int accId = resultSet.getInt("a.id");
				int mobileId = resultSet.getInt("m.id");
				int brandId = resultSet.getInt("b.id");
				String brandName = resultSet.getString("b.name");
				Brand brand = new Brand(brandId, brandName);
				float price = resultSet.getFloat("p.price");
				int quantity = resultSet.getInt("p.quantity");

				if (accId == 0) {
					String mobileName = resultSet.getString("m.name");
					int ram = resultSet.getInt("m.ram");
					int rom = resultSet.getInt("m.rom");
					int fcamera = resultSet.getInt("m.fcamera");
					int rcamera = resultSet.getInt("m.rcamera");
					object = new Mobile(mobileId, mobileName, ram, rom, fcamera, rcamera);
					product.setMobile((Mobile) object);
				}

				else if (mobileId == 0) {
					String accName = resultSet.getString("a.name");
					object = new Accessories(accId, accName);
					product.setAccessories((Accessories) object);
				}

				product.setId(productId);
				product.setBrand(brand);
				product.setPrice(price);
				product.setQuantity(quantity);
				list.add(product);
			}
		}

		catch (SQLException se) {
			throw new MobilecoException("Oops! Something went wrong " + se.getMessage());
		}

		finally {

			try {
				if (resultSet != null)
					resultSet.close();
				if (psmt != null)
					psmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException se) {
				throw new MobilecoException("Oops! Something went wrong.");
			}
		}

		return list;
	}

	// get list of alll mobiles
	public List<Product> getMobiles() throws MobilecoException {

		String query = "select * from product p join mobile m on p.mobile_id = m.id join brand b on p.brand_id = b.id";

		List<Product> list = new ArrayList<Product>();
		Connection connection = null;
		PreparedStatement psmt = null;
		ResultSet resultSet = null;

		try {
			connection = ConnectionUtil.getConnection();
			psmt = connection.prepareStatement(query);
			resultSet = psmt.executeQuery();

			while (resultSet.next()) {

				int productId = resultSet.getInt("p.id");
				int mobileId = resultSet.getInt("m.id");
				String mobileName = resultSet.getString("m.name");
				int ram = resultSet.getInt("m.ram");
				int rom = resultSet.getInt("m.rom");
				int fcamera = resultSet.getInt("m.fcamera");
				int rcamera = resultSet.getInt("m.rcamera");
				float price = resultSet.getFloat("p.price");
				int quantity = resultSet.getInt("p.quantity");
				int brandId = resultSet.getInt("b.id");
				String brandName = resultSet.getString("b.name");
				Brand brand = new Brand(brandId, brandName);

				Product product = new Product();
				Mobile mobile = new Mobile(mobileId, mobileName, ram, rom, fcamera, rcamera);

				product.setMobile(mobile);
				product.setId(productId);
				product.setPrice(price);
				product.setQuantity(quantity);
				product.setBrand(brand);

				list.add(product);
			}

		}

		catch (MobilecoException me) {

		}

		catch (SQLException se) {
			throw new MobilecoException("Oops! something wrong occured!");
		}

		finally {

			try {
				if (resultSet != null)
					resultSet.close();
				if (psmt != null)
					psmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException se) {
				throw new MobilecoException("Oops! Something went wrong.");
			}
		}

		return list;
	}

	// get list of all accessories
	public List<Product> getAccesories() throws MobilecoException {

		String query = "select * from product p join accessories a on p.accessories_id = a.id join brand b on p.brand_id = b.id";

		List<Product> list = new ArrayList<Product>();
		Connection connection = null;
		PreparedStatement psmt = null;
		ResultSet resultSet = null;

		try {
			connection = ConnectionUtil.getConnection();
			psmt = connection.prepareStatement(query);
			resultSet = psmt.executeQuery();

			while (resultSet.next()) {

				int productId = resultSet.getInt("p.id");
				int accId = resultSet.getInt("a.id");
				String accName = resultSet.getString("a.name");
				float price = resultSet.getFloat("p.price");
				int quantity = resultSet.getInt("p.quantity");
				int brandId = resultSet.getInt("b.id");
				String brandName = resultSet.getString("b.name");
				Brand brand = new Brand(brandId, brandName);
				Product product = new Product();
				Accessories accessories = new Accessories(accId, accName);
				product.setAccessories(accessories);
				product.setId(productId);
				product.setPrice(price);
				product.setQuantity(quantity);
				product.setBrand(brand);

				list.add(product);
			}

		}

		catch (MobilecoException me) {

		}

		catch (SQLException se) {
			throw new MobilecoException("Oops! something wrong occured!");
		}

		finally {

			try {
				if (resultSet != null)
					resultSet.close();
				if (psmt != null)
					psmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException se) {
				throw new MobilecoException("Oops! Something went wrong.");
			}
		}

		return list;
	}

	// update order quantity of product available in cart
	public void updateQuantity(Connection connection, int id, int orderQuantity) throws MobilecoException {
		// TODO Auto-generated method stub
		String query = "update product set quantity = quantity - ? where id = ?";
		PreparedStatement psmt = null;
		try {
			psmt = connection.prepareStatement(query);
			psmt.setInt(1, orderQuantity);
			psmt.setInt(2, id);
			psmt.executeUpdate();
		} catch (SQLException se) {
			throw new MobilecoException("Oops! Something wrong happened!");
		}

		finally {
			if (psmt != null)
				try {
					psmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

	}

}