package com.bridgelabz.JdbcPwdCheck;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.bridgelabz.jdbcfirst.Utility;

public class Interface {

	@SuppressWarnings("null")
	public static void main(String[] args) {
		System.out.println("Enter usename");
		String name = Utility.getString();

		System.out.println("Enter password");
		String pwd = Utility.getString();
		Statement stmt1 = null;
		Connection conn = null;
		Statement stmt = null;
		String username = " ";
		String password = " ";

		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Login", "root", "root");
			stmt = conn.createStatement();
			String sql = "SELECT * FROM login_info ";
			ResultSet rs = stmt.executeQuery(sql);

			// STEP 5: Extract data from result set
			while (rs.next()) {
				username = rs.getString("username");
				password = rs.getString("password");

				if (name.equals(username) && pwd.equals(password)) {
					System.out.println("LOGIN SUCCESSFUL");
					return;
				} else if (name.equals(username) && !pwd.equals(password)) {
					System.out.println("FORGOT PASSWORD");
					System.out.println("Enter the new password:");
					String new_pwd = Utility.getString();
					boolean res = ValidPwd.is_Valid_Password(new_pwd);
					if (res) {
						System.out.println("Re-enter the password:");
						String re_pwd = Utility.getString();
						if (re_pwd.equals(new_pwd)) {
							String sql1 = "UPDATE login_info SET password = ? where username =uesrname";
							PreparedStatement ps = conn.prepareStatement(sql1);
							ps.setString(2, re_pwd);
							System.out.println(password);
							ResultSet rs1 = ps.executeQuery();
							while (rs1.next()) {
								password = rs1.getString("password");
								System.out.println("PASSWORD CHANGED");
								return;
							}
						}
					}
				}
			}
			if (!name.equals(username)) {
				System.out.println("REGISTER ");
				System.out.println("enter your name");
				String name1 = Utility.getString();
				System.out.println("Enter your password");
				String password1 = Utility.getString();
				stmt1 = conn.createStatement();
				String sql1 = ("insert into login_info values(" + name1 + ", " + password1 + ")");
				stmt1.executeUpdate(sql1);
			}

		} catch (Exception se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (Exception se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (Exception se) {
				se.printStackTrace();
			} // end finally try
		} // end try
	}// end main*/
}