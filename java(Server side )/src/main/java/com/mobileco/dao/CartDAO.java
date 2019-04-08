package com.mobileco.dao;

/*
 * Author JJ
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mobileco.exceptions.MobilecoException;
import com.mobileco.model.Accessories;
import com.mobileco.model.Brand;
import com.mobileco.model.Cart;
import com.mobileco.model.Customer;
import com.mobileco.model.Mobile;
import com.mobileco.model.Product;
import com.mobileco.util.ConnectionUtil;

public class CartDAO {

	public CartDAO() {
		// TODO Auto-generated constructor stub
	}

	// add products to cart for that specific customer currently logged in
	public List<Cart> addToCart(Customer customer, Product product) throws MobilecoException {

		List<Cart> response = null;
		PreparedStatement pstmt = null;
		Connection connObj = null;
		String query = "insert into cart(customer_id,product_id) values(?,?)";

		try {
			System.out.println(customer + " " + product);
			connObj = ConnectionUtil.getConnection();
			connObj.setAutoCommit(false);
			pstmt = connObj.prepareStatement(query);
			pstmt.setInt(1, customer.getId());
			pstmt.setInt(2, product.getId());
			pstmt.executeUpdate();
			response = getItemsInCart(customer);
			connObj.commit();
		}

		catch (SQLException e) {
			try {
				connObj.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new MobilecoException("Item Already in cart :)");
		}

		finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (connObj != null)
					connObj.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return response;
	}

	// remove product from cart by removing cart object received as parameter in
	// method
	public List<Cart> removeFromCart(Cart cart) throws MobilecoException {
		List<Cart> itemsInCart = null;
		PreparedStatement pstmt = null;
		Connection connObj = null;
		String query = "delete from cart where customer_id = ? and product_id = ?";
		try {
			connObj = ConnectionUtil.getConnection();
			connObj.setAutoCommit(false);
			pstmt = connObj.prepareStatement(query);
			pstmt.setInt(1, cart.getCustomer().getId());
			pstmt.setInt(2, cart.getProduct().getId());
			pstmt.executeUpdate();
			itemsInCart = getItemsInCart(cart.getCustomer());
			connObj.commit();
		} catch (SQLException e) {
			try {
				connObj.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new MobilecoException("Oops! Something went wrong");
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (connObj != null)
					connObj.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return itemsInCart;
	}

	// get all items present in cart of customer
	public List<Cart> getItemsInCart(Customer customer) throws MobilecoException {

		String query = "select * from cart c" + " join product p on p.id = c.product_id"
				+ " join brand b on b.id = p.brand_id" + " left join mobile m on m.id = p.mobile_id"
				+ " left join accessories a on a.id = p.accessories_id" + " where c.customer_id=?";

		PreparedStatement psmt = null;
		ResultSet rs = null;
		Connection connection = null;

		List<Cart> productsInCart = new ArrayList<Cart>();

		try {
			connection = ConnectionUtil.getConnection();
			psmt = connection.prepareStatement(query);
			psmt.setInt(1, customer.getId());
			rs = psmt.executeQuery();

			while (rs.next()) {

				Product product = new Product();
				Object object = null;

				int productId = rs.getInt("p.id");
				int accId = rs.getInt("a.id");
				int mobileId = rs.getInt("m.id");
				int brandId = rs.getInt("b.id");
				String brandName = rs.getString("b.name");
				Brand brand = new Brand(brandId, brandName);
				float price = rs.getFloat("p.price");
				int StockQuantity = rs.getInt("p.quantity");
				int quantity = rs.getInt("c.quantity");

				if (accId == 0) {
					String mobileName = rs.getString("m.name");
					int ram = rs.getInt("m.ram");
					int rom = rs.getInt("m.rom");
					int fcamera = rs.getInt("m.fcamera");
					int rcamera = rs.getInt("m.rcamera");
					object = new Mobile(mobileId, mobileName, ram, rom, fcamera, rcamera);
					product.setMobile((Mobile) object);
				}

				else if (mobileId == 0) {
					String accName = rs.getString("a.name");
					object = new Accessories(accId, accName);
					product.setAccessories((Accessories) object);
				}

				product.setId(productId);
				product.setBrand(brand);
				product.setPrice(price);
				product.setQuantity(StockQuantity);

				productsInCart.add(new Cart(null, product, quantity));
			}
		}

		catch (SQLException se) {
			throw new MobilecoException("Oops! Something wrong happened!");
		}

		catch (MobilecoException me) {
			throw new MobilecoException("Oops! Something wrong happened!");
		}

		finally {
			try {
				if (rs != null)
					rs.close();
				if (psmt != null)
					psmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException se) {
				throw new MobilecoException("Oops! Something wrong happened!");
			}
		}

		return productsInCart;
	}

	// update product quantity available in cart
	public List<Cart> updateCartQuantity(Cart cart) throws MobilecoException {

		List<Cart> response = null;
		PreparedStatement pstmt = null;
		Connection connObj = null;
		String query = "update cart set quantity = ? where customer_id=? and product_id=?";

		try {
			connObj = ConnectionUtil.getConnection();
			connObj.setAutoCommit(false);
			pstmt = connObj.prepareStatement(query);
			pstmt.setInt(1, cart.getOrderQuantity());
			pstmt.setInt(2, cart.getCustomer().getId());
			pstmt.setInt(3, cart.getProduct().getId());
			pstmt.executeUpdate();
			response = getItemsInCart(cart.getCustomer());
			connObj.commit();
		}

		catch (SQLException e) {
			try {
				connObj.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			throw new MobilecoException("Oops! Something went wrong!");
		}

		finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (connObj != null)
					connObj.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return response;
	}

	// to empty cart after successfully placing order
	public void emptyCart(Connection connection, int id) throws MobilecoException {

		String query = "delete from cart where customer_id=?";

		PreparedStatement psmt = null;

		try {
			psmt = connection.prepareStatement(query);
			psmt.setInt(1, id);
			psmt.executeUpdate();
		}

		catch (SQLException se) {
			throw new MobilecoException("Oops! Something went wrong.");
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
