package com.bridgelabz.jdbcfirst;

import java.sql.*;

public class FirstJdbc {

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/Student";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "root";

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
			// STEP 2: Register JDBC driver 
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT * FROM Student_info";
			ResultSet rs = stmt.executeQuery(sql);

			// STEP 5: Extract data from result set
			while (rs.next()) {
				// Retrieve by column name
				int id = rs.getInt("id");
				String name = rs.getString("name"); 
				String clgName = rs.getString("clg_name");
				String email = rs.getString("email");

				// Display values
				System.out.println("ID: " + id);
				System.out.println("Name: " + name);
				System.out.println("College Name: " + clgName);
				System.out.println("Email_id: " + email);
			}
		} catch (Exception se) {
			// Handle errors for JDBC
			se.printStackTrace();
		
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
	}// end main
}// end FirstExample