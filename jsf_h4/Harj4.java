package book;

import java.sql.*;



public class Harj4 {

			
	 
	 
	 
	 
	
		 public final static String user = "";
		 public final static String passwd = "";
		 public final static String url = "jdbc:h2:tcp://localhost:9092/mem:jpatest;DB_CLOSE_DELAY=1000"; 
		  
		 
		 
		 public static void main(String args[]){
			 
		 
		 // create connection to database conn
			 try {
		 Connection conn = null;
		 
		 String JDBC_DRIVER = "org.h2.jdbcx.JdbcDataSource";
		 Statement stmt = null;
	     conn = DriverManager.getConnection(url, user, passwd);

	  
	      Class.forName(JDBC_DRIVER);

	      
	      stmt = conn.createStatement();
	      
	      String sql = "CREATE DATABASE oppilaatS";
	      stmt.executeUpdate(sql);
			 }catch(SQLException | ClassNotFoundException e){}
	  
	 
		 } 

   
}
