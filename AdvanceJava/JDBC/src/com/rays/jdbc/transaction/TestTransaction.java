package com.rays.jdbc.transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestTransaction {

	public static void main(String[] args) throws Exception {
		
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "rott", "root");
			
			conn.setAutoCommit(false);
			
			Statement stmt = conn.createStatement();
			
			int i = stmt.executeUpdate(
					"insert into st_user values (r values(6, 'Suresh', 'Yadav', 'suresh@gmail.com', 'suresh123', '2001-01-01')");
			
			i = stmt.executeUpdate(
					"insert into st_user values(7, 'Suresh', 'Yadav', 'suresh@gmail.com', 'sur '2001-01-01')");
			
			i = stmt.executeUpdate(
					"insert into st_user values(8, 'Suresh', 'Yadav', 'suresh@gmail.com', 'suresh123', '2001-01-0)");
			
			conn.commit();
			System.out.println("transaction completed");
			conn.close();
			stmt.close();
		}catch(Exception e) {
			e.printStackTrace();
			conn.rollback();
		}
	}
}
