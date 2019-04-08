package com.mobileco.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mobileco.exceptions.MobilecoException;
import com.mobileco.model.Address;
import com.mysql.jdbc.Statement;

public class AddressDAO {

	public AddressDAO() {

	}

	// to register address
	public int registerAddress(Connection connObj, Address address) throws MobilecoException {

		String query = "insert into address(street,city,state,country,pincode) values(?,?,?,?,?)";

		PreparedStatement pstmt = null;
		ResultSet result = null;
		int key = 0;

		try {
			pstmt = connObj.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, address.getStreet());
			pstmt.setString(2, address.getCity());
			pstmt.setString(3, address.getState());
			pstmt.setString(4, address.getCountry());
			pstmt.setString(5, address.getPincode());
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

	// update existing address
	public void updateAddress(Connection connObj, Address address) throws MobilecoException {

		String query = "update address set street = ?, city = ?,state = ?,country = ?,pincode = ? where id = ?";
		PreparedStatement pstmt = null;
		try {
			pstmt = connObj.prepareStatement(query);
			pstmt.setString(1, address.getStreet());
			pstmt.setString(2, address.getCity());
			pstmt.setString(3, address.getState());
			pstmt.setString(4, address.getCountry());
			pstmt.setString(5, address.getPincode());
			pstmt.setInt(6, address.getId());
			pstmt.executeUpdate();
		}

		catch (SQLException e) {
			throw new MobilecoException("Exception in registerCustomer " + e);
		}

		finally {

			try {
				if (pstmt != null)
					pstmt.close();
			}

			catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// get address details by address Id
	public Address getAddressById(Connection connObj, int id) throws MobilecoException {
		PreparedStatement pstmt = null;
		ResultSet result = null;
		String query = "select * from address where id = " + id;
		String street;
		String city;
		String state;
		String country;
		String pincode;
		try {
			pstmt = connObj.prepareStatement(query);
			result = pstmt.executeQuery();
			if (result.next()) {
				street = result.getString("street");
				city = result.getString("city");
				state = result.getString("state");
				country = result.getString("country");
				pincode = result.getString("pincode");
			}

			else {
				throw new MobilecoException("No address found!");
			}

		}

		catch (SQLException e) {
			throw new MobilecoException("Exception in registerCustomer " + e);
		}

		finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return new Address(id, street, city, state, country, pincode);
	}

}
