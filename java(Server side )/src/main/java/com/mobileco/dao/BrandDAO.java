package com.mobileco.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mobileco.exceptions.MobilecoException;
import com.mobileco.model.Brand;
import com.mobileco.util.ConnectionUtil;
import com.mysql.jdbc.Statement;

public class BrandDAO {

	public BrandDAO() {
		// TODO Auto-generated constructor stub
	}

	// to register brand details of a product
	public int registerBrand(Brand brand) {

		String query = "insert into brand(name) values('?')";
		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int generatedId = 0;

		try {
			connection = ConnectionUtil.getConnection();
			stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, brand.getName());
			stmt.executeUpdate();

			rs = stmt.getGeneratedKeys();

			if (rs.next()) {
				generatedId = rs.getInt(1);
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

		finally {
			if (connection != null)

				try {
					connection.close();
				}

				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

		return generatedId;
	}
}
