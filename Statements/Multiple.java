package com.bridgelabz.Statements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bridgelabz.jdbcfirst.Utility;

public class Multiple {
	static Connection conn = null;
	static Statement stmt = null;
	static ResultSet rs = null;

	public static void main(String[] args) {
		
		String Driver = "com.mysql.jdbc.Driver";

		try {
			Class.forName(Driver);
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student", "root", "root");
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Enter 1 to create table");
		System.out.println("Enter 2 to insert table");
		System.out.println("Enter 3 to read table");
		System.out.println("Enter 4 to update table");
		System.out.println("Enter 5 to delete values inside the table");
		int choice = Utility.getInteger();
		do{
		switch (choice) {
		case 1:
			create();
			break;
		case 2:
			insert();
			break;
		case 3:
			read();
			break;
		case 4:
			update();
			break;
		case 5:
			delete();
			break;
		default:
			break;
		}
			System.out.println("Do you want to continue: y/n");  
			String s=Utility.getString();
			if(s.startsWith("y")){ 
			choice=2;
			}
			if(s.startsWith("n")){  
			break; 
			}
			}while(true);	
		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}
	
	public static void create() {

		String query = "create table Student_Info(id int(3) primary key,name varchar(20), clg_name varchar(20),email varchar(20))";
		try {
			Statement stmt = conn.createStatement();
			int i = stmt.executeUpdate(query);
			System.out.println(i + " records created");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public static void insert() {
		String query = "insert into Student_Info values(4,'medini','SJBIT','medini234@gmail.com')";
		try {

			Statement stmt = conn.createStatement();
			int i = stmt.executeUpdate(query);
			System.out.println(i + " records inserted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void read() {
		String query = "select * from Student_Info";
		try {
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String clgName = rs.getString("clg_name");
				String email = rs.getString("email");

				System.out.println("ID: " + id);
				System.out.println("Name: " + name);
				System.out.println("College Name: " + clgName);
				System.out.println("Email_id: " + email);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void update() {
		String query = "update Student_Info set name='shruti' where id=4";
		try {
			Statement stmt = conn.createStatement();
			int i = stmt.executeUpdate(query);
			System.out.println(i + " row updated");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void delete() {
		String query = "delete from Student_Info where id=4";
		try {
			Statement stmt = conn.createStatement();
			int i = stmt.executeUpdate(query);
			System.out.println(i + " rows deleted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}