package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestConnection {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
		
		System.out.println("Connection was successfull");
		
		Statement stmt = conn.createStatement();
		
		ResultSet rs = stmt.executeQuery("select * from st_u");
		
		while (rs.next()) {
			System.out.print(rs.getInt(1));
			System.out.print("\t"+ rs.getString(2));
			System.out.print("\t"+ rs.getString(3));
			System.out.print("\t"+ rs.getInt(4));
			System.out.println("\t"+ rs.getInt(5));
		}
		
	}
}
