package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
		
		Statement stmt = conn.createStatement();
	
		//stmt.executeUpdate("create table st_user(id int primary key, firstName varchar(45), lastName varchar (45), login varchar(45), password varchar(45), dob date)");
		
		//int i = stmt.executeUpdate("insert into st_user values (1,'Rahul', 'Sharma', 'rahul123', 'hashed_password1', '1998-05-14'),\r\n"
			//	+ "(2,'Priya', 'Mehta', 'priya.m', 'hashed_password2', '1997-09-21'),\r\n"
			//	+ "(3,'Amit', 'Verma', 'amit_v', 'hashed_password3', '1995-12-03'),\r\n"
		///		+ "(4,'Sneha', 'Kapoor', 'sneha.k', 'hashed_password4', '1999-02-18'),\r\n"
			//	+ "(5,'Arjun', 'Rao', 'arjun_rao', 'hashed_password5', '1996-07-30'),\r\n"
			//	+ "(6,'Neha', 'Gupta', 'neha.g', 'hashed_password6', '1998-11-11'),\r\n"
			///	+ "(7,'Karan', 'Malhotra', 'karan_m', 'hashed_password7', '1994-04-25');");
		
		System.out.println("table is created");
		conn.close();
	}
}
