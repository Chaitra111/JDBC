package com.bridgelabz.Batch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class BatchPrpdStmt {
	
	static PreparedStatement ps=null;
	static Connection con = null;
	
	@SuppressWarnings("unused")
	public static void main(String[] args) throws Exception{
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root");

		String sql1 = "insert into Employee_Info values(?,?,?,?)";
		
		ps = con.prepareStatement(sql1);
		ps.setInt( 1, 7);
		ps.setString( 2, "ankita" );
		ps.setString( 3, "yatra" );
		ps.setString( 4, "yatrapar@gmail.com" );
		// Add it to the batch
		ps.addBatch();
		con.setAutoCommit(false);

		ps.setInt(1, 8);
		ps.setString(2,"aruna");
		ps.setString(3, "intellect");
		ps.setString(4, "aruna1995@gmail.com" );
		ps.addBatch();
		con.setAutoCommit(false);
		
		int[] counts = ps.executeBatch();
		System.out.println("Success");
		con.commit();
		try {

			if (ps != null) {
				ps.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (Exception se) {
			se.printStackTrace();
		}
	}
}    
