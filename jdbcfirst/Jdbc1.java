package com.bridgelabz.jdbcfirst;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Jdbc1 {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/Student";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "root";

	public static void main(String args[]) {
		try {
			String id = args[0];
			String name = args[1];
			String clgName = args[2];
			String email = args[3];
			Class.forName(JDBC_DRIVER);

			Connection con = DriverManager.getConnection(DB_URL, USER, PASS);

			PreparedStatement ps = con.prepareStatement("insert into Student_info values(?,?,?,?)");
			ps.setInt(1, Integer.parseInt(id));// 1 specifies the first parameter in the query
			ps.setString(2, name);
			ps.setString(3, clgName);
			ps.setString(4, email);
			ps.executeUpdate();
			con.close();
			ps.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
