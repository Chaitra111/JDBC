package com.bridgelabz.jdbcfirst;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;



public class DataSourceExample {
	
	  /*public static DataSource getMysqlDataSource() {
	  MysqlDataSource dataSource = new MysqlDataSource();

	    // Set dataSource Properties
	    dataSource.setServerName("localhost");
	    dataSource.setPortNumber(3306);
	    dataSource.setDatabaseName("Student");
	    dataSource.setUser("root");
	    dataSource.setPassword("root");
	    return dataSource;
	  }

	  public static void main(String[] args) {

	    Connection conn = null;
	    Statement stmt = null;
	    ResultSet rs = null;
	    try {

	      // Get connection from DataSource
	      conn = getMysqlDataSource().getConnection();
	      stmt = conn.createStatement();
	      rs = stmt.executeQuery("SELECT * from Student_info");
	      
	      if (rs.next()) {
	        System.out.println("Database Version : " + rs.getString(1));
	      }
	    } catch (Exception e) {
	      e.printStackTrace();
	    } finally {
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
	      } catch (Exception e) {
	        e.printStackTrace();
	      }
	    }
	  }*/
	
	
}
