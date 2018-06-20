package com.bridgelabz.Statements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bridgelabz.jdbcfirst.Utility;



public class Crud {

	static Connection conn = null;
	static PreparedStatement ps=null;
	static Statement stmt=null;
	static ResultSet rs=null;
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
				
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
			
			try {
				ps = conn.prepareStatement("create table Student_Info(id int(3) primary key,name varchar(20), clg_name varchar(20),email varchar(20))");
			    int i= ps.executeUpdate();
			    System.out.println(i+" records created" );
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		public static void insert() {
			
			try {
				ps = conn.prepareStatement("insert into Student_info values(?,?,?,?)");
				ps.setInt(1, 6);// 1 specifies the first parameter in the query
				ps.setString(2, "Aruna");
				ps.setString(3, "SJBIT");
				ps.setString(4, "aruna1995@gmail.com");
				int i = ps.executeUpdate();
				
				System.out.println(i+" records inserted");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public static void read() {
			
			try {
				ps = conn.prepareStatement("SELECT * FROM Student_info");
				rs = ps.executeQuery("SELECT * FROM Student_info");
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
						
			try {
				ps = conn.prepareStatement("update Student_info set id=? where id=?");
				int i = ps.executeUpdate();
				System.out.println(i);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
		}
		public static void delete() {
		
			try {
				ps=conn.prepareStatement("delete from Student_info where id=6");
				int i = ps.executeUpdate();
				System.out.println(i);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
	}
	