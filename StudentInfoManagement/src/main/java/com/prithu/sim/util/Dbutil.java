package com.prithu.sim.util;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;

public class Dbutil {
	
	private static final String DRIVER_NAME ="com.mysql.jdbc.Driver";
	private static final String URL ="jdbc:mysql://localhost:3306/";
	private static final String DB_NAME ="swing_crud";
	private static final String USER_NAME ="root";
	private static final String PASSWORD ="root";

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(DRIVER_NAME);
		return DriverManager.getConnection(URL+DB_NAME,USER_NAME,PASSWORD);
	}
	 
}
