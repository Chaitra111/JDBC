package com.bridgelabz.PreparedStatements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bridgelabz.jdbcfirst.Utility;

public class Multiple {

	static Connection conn = null;
	static PreparedStatement ps = null;
		
	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root");
			
			String query = "insert into Employee_Info values(?,?,?,?)";
			ps = conn.prepareStatement(query);
			do {
			System.out.println("Enter employee id:");
			int id = Utility.getInteger();
			System.out.println("Enter employee name:");
			String name = Utility.getString();
			System.out.println("Enter company name:");
			String company_name = Utility.getString();
			System.out.println("Enter email id:");
			String email = Utility.getString();
			
			ps.setInt(1, id );
			ps.setString(2, name);
			ps.setString(3, company_name);
			ps.setString(4, email );
			int i=ps.executeUpdate();
			
			System.out.println("ID: " + id);
			System.out.println("Name: " + name);
			System.out.println("Company Name: " + company_name);
			System.out.println("Email_id: " + email);
			System.out.println(i+" rows inserted");
			
			System.out.println("Do you want to continue: y/n");  
			String s=Utility.getString(); 
			
			if(s.startsWith("n")){  
			break; 
			}
			}while(true);
		}
		 catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	try {
		
		if (ps!= null) {
			ps.close();
		}
		if (conn != null) {
			conn.close();
		}
	} catch (SQLException se) {
		se.printStackTrace();
	}
	}
	
}
