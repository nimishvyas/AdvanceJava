package com.rays.jdbc.preparedStatement;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserModel {

	public int add(UserBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
		
		PreparedStatement pstmt = conn.prepareStatement("insert into st_user values(?, ?, ?, ?, ?, ?)");
		
		pstmt.setInt(1, bean.getId());
		pstmt.setString(2, bean.getFirstName());
		pstmt.setString(3, bean.getLastName());
		pstmt.setString(4, bean.getLogin());
		pstmt.setString(5, bean.getPassword());
		pstmt.setDate(6, new java.sql.Date(bean.getDob().getTime()));
		
		int i = pstmt.executeUpdate();
		
		System.out.println(i + "row affected(record inserted)");
		
		conn.close();
		pstmt.close();
		return bean.getId();
	}
	
	public void update(UserBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
		
		PreparedStatement pstmt = conn.prepareStatement("update st_user set firstName = ?, lastName= ?, login = ?, password = ?, dob = ? where id = ?");
		pstmt.setString(1, bean.getFirstName());
		pstmt.setString(2, bean.getLastName());
		pstmt.setString(3, bean.getLogin());
		pstmt.setString(4, bean.getPassword());
		pstmt.setDate(6, new java.sql.Date(bean.getDob().getTime()));
		
		int i = pstmt.executeUpdate();
		System.out.println(i + "row affected (record updated)");
		conn.close();
		pstmt.close();
	}
	
	public void delete(UserBean bean) throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
		
		PreparedStatement pstmt = conn.prepareStatement("delete from st_user where id= ?");
		pstmt.setInt(1, bean.getId());
		int i = pstmt.executeUpdate();
		System.out.println(i + "row affected (record deleted)");
		conn.close();
		pstmt.close();		
	}
}
