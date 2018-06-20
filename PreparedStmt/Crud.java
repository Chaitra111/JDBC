package com.bridgelabz.PreparedStmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bridgelabz.jdbcfirst.Utility;

public class Crud {
	static Connection conn = null;
	static Statement stmt=null;
	static ResultSet rs=null;
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException  {
			
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student", "root", "root");
		

		System.out.println("Enter 1 to create table");
		System.out.println("Enter 2 to insert table");
		System.out.println("Enter 3 to read table");
		System.out.println("Enter 4 to update table");
		System.out.println("Enter 5 to delete values inside the table");
		int choice = Utility.getInteger();
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
		try {
			if(rs!=null) {
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
			
			String query="create table Employee_Info(id int(3) primary key,name varchar(20), clg_name varchar(20),email varchar(20))";
			try {
				Statement stmt=conn.createStatement();
				int i= stmt.executeUpdate(query);
			    System.out.println(i+" records created" );
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		public static void insert() {
			String query="insert into Student_info values(1,'chaitra','SDM','111cghaj@gmail.com')";
			try {
				
				Statement stmt=conn.createStatement();
				int i= stmt.executeUpdate(query);
				System.out.println(i+" records inserted");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public static void read() {
			String query="SELECT * FROM Student_info";
			try {
				Statement stmt=conn.createStatement();
				rs =stmt.executeQuery(query);
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
			String query="update Student_info set id=? where id=?";
			try {
				Statement stmt=conn.createStatement();
				int i= stmt.executeUpdate(query);
				System.out.println(i);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
		}
		public static void delete() {
			String query="delete from Student_info where id=6";
			try {
				Statement stmt=conn.createStatement();
				int i= stmt.executeUpdate(query);
				System.out.println(i);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
	}