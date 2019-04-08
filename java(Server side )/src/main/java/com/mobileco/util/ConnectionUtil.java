package com.mobileco.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mobileco.exceptions.MobilecoException;

public class ConnectionUtil {

	public ConnectionUtil() {
		// TODO Auto-generated constructor stub
	}

	public static Connection getConnection() throws MobilecoException {

		Connection obj = null;
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			obj = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/e_commerce?verifyServerCertificate=false&useSSL=true", "root", "root");
			if (obj == null) {
				System.out.println("no connection ");
			} else {
				System.out.println("successfully got connection" + obj);
			}
		} catch (SQLException e) {
			System.out.println("Error while connecting to DB");
			throw new MobilecoException(e.getMessage());
		}

		return obj;
	}
}
