package com.bridgelabz.PreparedStatements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bridgelabz.jdbcfirst.Utility;

public class Crud {

	static Connection conn = null;
	static PreparedStatement ps = null;
	static ResultSet rs = null;

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root");

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
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
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
			ps = conn.prepareStatement("create table Employee_Info(id int(3) primary key,name varchar(20), company_name varchar(20),email varchar(20))");
			int i = ps.executeUpdate();
			System.out.println(i + " records created");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public static void insert() {

		try {
			ps = conn.prepareStatement("insert into Employee_Info values(?,?,?,?)");
			ps.setInt( 1, 9);
			ps.setString( 2, "martin" );
			ps.setString( 3, "yatra" );
			ps.setString( 4, "yatrapar@gmail.com" );
			int i = ps.executeUpdate();

			System.out.println(i + " records inserted");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void read() {

		try {
			ps = conn.prepareStatement("SELECT * FROM Employee_Info");
			rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String cmpName = rs.getString("company_name");
				String email = rs.getString("email");

				System.out.println("ID: " + id);
				System.out.println("Name: " + name);
				System.out.println("Company Name: " + cmpName);
				System.out.println("Email_id: " + email);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void update() {

		try {
			ps = conn.prepareStatement("update Employee_Info set name=? where id=?");
			ps.setString( 1, "priya" );
			ps.setInt( 2, 9);
			int i = ps.executeUpdate();
			System.out.println(i + " row updated");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void delete() {

		try {
			ps = conn.prepareStatement("delete from Employee_Info where id=?");
			ps.setInt(1,9);
			int i = ps.executeUpdate();
			System.out.println(i + " row deleted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
