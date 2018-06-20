package com.bridgelabz.jdbcfirst;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Jdbc3 {
	        // JDBC driver name and database URL
			static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
			static final String DB_URL = "jdbc:mysql://localhost:3306/Student";

			// Database credentials
			static final String USER = "root";
			static final String PASS = "root";

				public static void main(String args[]){  
			try {
				Class.forName(JDBC_DRIVER);

				Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
			    /*PreparedStatement stmt=con.prepareStatement("delete from Student_info where id=?");  
			    stmt.setInt(1,6);  
			      
			    int i=stmt.executeUpdate();  
			    System.out.println(i+" records deleted");  
				con.close();*/
			    PreparedStatement stmt=con.prepareStatement("update Student_info set id=? where id=?");  
			    stmt.setInt(1,5);//1 specifies the first parameter in the query i.e. name  
			    stmt.setInt(2,101);  
			      
			    int i=stmt.executeUpdate();  
			    System.out.println(i+" records updated");  

			} catch (Exception e) {
				System.out.println(e);
			}

		}
	}
					