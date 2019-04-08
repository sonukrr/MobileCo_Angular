package com.mobileco.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mobileco.exceptions.MobilecoException;
import com.mobileco.model.Address;
import com.mobileco.model.Customer;
import com.mobileco.util.ConnectionUtil;

public class CustomerDAO {

	public CustomerDAO() {
	}

	// register new customer
	public int registerCustomer(Customer customer) throws MobilecoException {
		PreparedStatement pstmt = null;
		ResultSet result = null;
		Connection connObj = ConnectionUtil.getConnection();
		int key = 0;
		try {

			pstmt = connObj.prepareStatement(
					"insert into customer(name,email,phone,password,address_id) values(?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);

			pstmt.setString(1, customer.getName());
			pstmt.setString(2, customer.getEmail());
			pstmt.setString(3, customer.getPhone());
			pstmt.setString(4, customer.getPassword());
			AddressDAO addressDao = new AddressDAO();
			int addressId = addressDao.registerAddress(connObj, customer.getAddress());
			pstmt.setInt(5, addressId);
			pstmt.executeUpdate();
			result = pstmt.getGeneratedKeys();
			if (result.next()) {
				key = result.getInt(1);
			}

		} catch (SQLException e) {
			throw new MobilecoException("Exception in registerCustomer " + e);
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (result != null)
					result.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return key;
	}

	// updatre details of existing customer
	public void updateCustomer(Customer customer) throws MobilecoException {
		PreparedStatement pstmt = null;
		Connection connObj = ConnectionUtil.getConnection();
		try {
			pstmt = connObj.prepareStatement(
					"update customer set name = ?, email = ?,phone = ?,password = ?,address_id = ? where id = ?");
			pstmt.setString(1, customer.getName());
			pstmt.setString(2, customer.getEmail());
			pstmt.setString(3, customer.getPhone());
			pstmt.setString(4, customer.getPassword());
			pstmt.setInt(5, customer.getAddress().getId());
			pstmt.setInt(6, customer.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new MobilecoException("Exception in registerCustomer " + e);
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// fetch customer details by ID
	public Customer getCustomerById(int id) throws MobilecoException {
		PreparedStatement pstmt = null;
		Connection connObj = ConnectionUtil.getConnection();
		String name;
		String email;
		String phone;
		String password;
		Address address;
		ResultSet result = null;
		try {
			pstmt = connObj.prepareStatement(
					"select * from customer as cus join address as ad on cus.address_id = ad.id where cus.id = " + id);
			result = pstmt.executeQuery();
			if (result.next()) {
				name = result.getString("name");
				email = result.getString("email");
				phone = result.getString("phone");
				password = result.getString("password");
				address = new Address(result.getInt("address_id"), result.getString("pincode"),
						result.getString("street"), result.getString("city"), result.getString("state"),
						result.getString("country"));
			} else {
				throw new MobilecoException("No customer found!");
			}

		} catch (SQLException e) {
			throw new MobilecoException("Exception in registerCustomer " + e);
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return new Customer(id, name, email, phone, password, address);
	}

	// check authenticity of customer
	public Customer loginCheck(Customer customer) {
		Customer loggedInUser = null;

		String query = "select * from customer c " + "left join address a on a.id = c.address_id "
				+ "where c.email=? and c.password=?";

		ResultSet rs = null;
		PreparedStatement stmt = null;

		try {
			Connection conn = ConnectionUtil.getConnection();
			stmt = conn.prepareStatement(query);
			stmt.setString(1, customer.getEmail());
			stmt.setString(2, customer.getPassword());
			rs = stmt.executeQuery();

			if (rs.next()) {
				Address address = null;

				if (rs.getInt("c.address_id") > 0) {

					address = new Address(rs.getInt("a.id"), rs.getString("a.street"), rs.getString("a.city"),
							rs.getString("a.state"), rs.getString("country"), rs.getString("a.pincode"));

				}

				loggedInUser = new Customer(rs.getInt("c.id"), rs.getString("c.name"), rs.getString("c.email"),
						rs.getString("c.phone"), null, address);
			}

		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		catch (MobilecoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return loggedInUser;
	}

}
