package com.bridgelabz.Batch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchStamt {
	
	static Connection con = null;
	static Statement st = null;
	
	@SuppressWarnings("unused")
	public static void main(String[] args) throws Exception{
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root");

		Statement st = con.createStatement();
		con.setAutoCommit(false);
		String sql1 = "insert into Employee_Info values(16,'ankita','capgemini','ankita189@gmail.com')";
		String sql2= "insert into Employee_Info values(17,'medini','capgemini','medini189@gmail.com')";
		st.addBatch(sql1);
		st.addBatch(sql2);
		
		int[] counts = st.executeBatch();
		System.out.println("Success");
		con.commit();
		try {

			if (st != null) {
				st.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}
}    

