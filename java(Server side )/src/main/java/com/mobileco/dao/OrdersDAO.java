package com.mobileco.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.mobileco.exceptions.MobilecoException;
import com.mobileco.model.Brand;
import com.mobileco.model.Cart;
import com.mobileco.model.Customer;
import com.mobileco.model.Orders;
import com.mobileco.model.Product;
import com.mobileco.util.ConnectionUtil;

public class OrdersDAO {

	public OrdersDAO() {
		// TODO Auto-generated constructor stub
	}

	// get all orders placed by hat customer
	public List<Orders> getAllOrders(Customer customer) {
		String query = "Select o.id,o.date_ordered,o.date_expected,o.date_delivered,o.quantity, "
				+ "o.product_id,m.name as product,b.name as brand,p.brand_id, p.price " + "from orders o "
				+ "inner join brand b " + "inner join customer c " + "inner join product p " + "inner join mobile m "
				+ "on o.product_id=p.id " + "and p.mobile_id=m.id " + "and p.brand_id=b.id " + "and o.customer_id=c.id "
				+ "where c.id=? " + "union " + "Select o.id,o.date_ordered,o.date_expected,o.date_delivered,o.quantity,"
				+ "o.product_id,a.name as product,b.name as brand,p.brand_id, p.price " + "from orders o "
				+ "inner join brand b " + "inner join customer c " + "inner join product p "
				+ "inner join accessories a " + "on o.product_id=p.id " + "and p.accessories_id=a.id "
				+ "and p.brand_id=b.id " + "and o.customer_id=c.id " + "and p.accessories_id=a.id " + "where c.id=? ";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Orders> ordersList = new ArrayList<Orders>();
		try {
			conn = ConnectionUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, customer.getId());
			pstmt.setInt(2, customer.getId());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Orders order = new Orders();
				order.setId(rs.getInt("id"));
				String date = rs.getString("date_ordered");
				// convert String to LocalDate
				DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				LocalDate orderDate = LocalDate.parse(date, format);
				order.setDateOrdered(orderDate);
				date = rs.getString("date_expected");
				LocalDate expectedDate = LocalDate.parse(date, format);
				order.setDateExpected(expectedDate);
				date = rs.getString("date_delivered");
				if (date != null) {
					LocalDate deliveredDate = LocalDate.parse(date, format);
					order.setDateExpected(deliveredDate);
				} else {
					order.setDateDelivered(null);
				}
				order.setQuantity(rs.getInt("quantity"));
				Product product = new Product();

				product.setId(rs.getInt("product_id"));
				order.setProductName(rs.getString("product"));
				Brand brand = new Brand();
				brand.setId(rs.getInt("brand_id"));
				brand.setName("brand");
				product.setPrice(rs.getFloat("price"));
				order.setCustomer(customer);
				product.setBrand(brand);
				order.setProduct(product);

				ordersList.add(order);
			}

		} catch (MobilecoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}

		}
		return ordersList;
	}

	// get list of pending orders of customer
	public List<Orders> getPendingOrders(Customer customer) {
		String query = "Select o.id,o.date_ordered,o.date_expected,o.date_delivered,o.quantity, "
				+ "o.product_id,m.name as product,b.name as brand,p.brand_id, p.price " + "from orders o "
				+ "inner join brand b " + "inner join customer c " + "inner join product p " + "inner join mobile m "
				+ "on o.product_id=p.id " + "and p.mobile_id=m.id " + "and p.brand_id=b.id " + "and o.customer_id=c.id "
				+ "where c.id=? and o.date_delivered is null " + "union "
				+ "Select o.id,o.date_ordered,o.date_expected,o.date_delivered,o.quantity,"
				+ "o.product_id,a.name as product,b.name as brand,p.brand_id, p.price " + "from orders o "
				+ "inner join brand b " + "inner join customer c " + "inner join product p "
				+ "inner join accessories a " + "on o.product_id=p.id " + "and p.accessories_id=a.id "
				+ "and p.brand_id=b.id " + "and o.customer_id=c.id " + "and p.accessories_id=a.id "
				+ "where c.id=? and o.date_delivered is null";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Orders> ordersList = new ArrayList<Orders>();
		try {
			conn = ConnectionUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, customer.getId());
			pstmt.setInt(2, customer.getId());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Orders order = new Orders();
				order.setId(rs.getInt("id"));
				String date = rs.getString("date_ordered");
				// convert String to LocalDate
				DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				LocalDate orderDate = LocalDate.parse(date, format);
				order.setDateOrdered(orderDate);
				date = rs.getString("date_expected");
				LocalDate expectedDate = LocalDate.parse(date, format);
				order.setDateExpected(expectedDate);
				date = rs.getString("date_delivered");
				if (date != null) {
					LocalDate deliveredDate = LocalDate.parse(date, format);
					order.setDateExpected(deliveredDate);
				} else {
					order.setDateDelivered(null);
				}
				order.setQuantity(rs.getInt("quantity"));
				Product product = new Product();

				product.setId(rs.getInt("product_id"));
				order.setProductName(rs.getString("product"));
				Brand brand = new Brand();
				brand.setId(rs.getInt("brand_id"));
				brand.setName("brand");
				product.setPrice(rs.getFloat("price"));
				order.setCustomer(customer);
				product.setBrand(brand);
				order.setProduct(product);

				ordersList.add(order);
			}

		} catch (MobilecoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}

		}
		return ordersList;
	}

	// to place order of products available in customer cart
	public void placeOrder(List<Cart> cartItems, Customer customer) throws MobilecoException {
		String query = "insert into orders(date_ordered, date_expected, quantity, product_id, customer_id)"
				+ "values(curdate(), date_add(curdate(), interval 7 day), ?,?,?)";

		Connection connection = null;
		PreparedStatement psmt = null;

		try {
			connection = ConnectionUtil.getConnection();
			connection.setAutoCommit(false);
			psmt = connection.prepareStatement(query);
			ProductDAO productDao = new ProductDAO();
			for (Cart itemInCart : cartItems) {
				psmt.setInt(1, itemInCart.getOrderQuantity());
				psmt.setInt(2, itemInCart.getProduct().getId());
				psmt.setInt(3, customer.getId());
				psmt.executeUpdate();
				productDao.updateQuantity(connection, itemInCart.getProduct().getId(), itemInCart.getOrderQuantity());
			}
			CartDAO cartDao = new CartDAO();
			cartDao.emptyCart(connection, customer.getId());
			connection.commit();
		}

		catch (MobilecoException me) {
			try {
				connection.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			throw new MobilecoException("Oops! Something went wrong.");
		}

		catch (SQLException se) {
			try {
				connection.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			se.printStackTrace();
			throw new MobilecoException("Error in placing order");
		}

		finally {
			try {
				if (psmt != null)
					psmt.close();
				if (connection != null)
					connection.close();
			}

			catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}
}
