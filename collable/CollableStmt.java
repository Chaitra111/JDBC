package com.bridgelabz.collable;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CollableStmt {
	
	static Connection conn = null;
	static CallableStatement cstmt = null;
	static ResultSet rs=null;

	  public static void main(String[] args) {
		  
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root");

			cstmt = conn.prepareCall("call getEmployee ()");
			rs=cstmt.executeQuery();
			while (rs.next()) {
				
				int id = rs.getInt("id");
				String name = rs.getString("name"); 
				String company_name = rs.getString("company_name");
				String email = rs.getString("email");
				
				System.out.println("ID: " + id);
				System.out.println("Name: " + name);
				System.out.println("Company Name: " +company_name);
				System.out.println("Email_id: " + email);
			}
			} catch (SQLException se) {
				se.printStackTrace();
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			try {
				if (cstmt != null)
					cstmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} 
		} 
	}
}