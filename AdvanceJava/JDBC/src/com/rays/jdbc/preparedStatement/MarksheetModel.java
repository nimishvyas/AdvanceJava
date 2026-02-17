package com.rays.jdbc.preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MarksheetModel {

	public int add(MarksheetBean bean) throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
		
		PreparedStatement pstmt = conn.prepareStatement("insert into marksheet values (?, ?, ?, ?, ?, ?)");
		
		pstmt.setInt(1, bean.getId());
		pstmt.setString(2, bean.getRollNo());
		pstmt.setString(3, bean.getName());
		pstmt.setInt(4, bean.getPhy());
		pstmt.setInt(5, bean.getChm());
		pstmt.setInt(6, bean.getMaths());
		
		int i = pstmt.executeUpdate();
		System.out.println(i+ " row affected(values inserted)");
		return bean.getId();
	}
	public void update(MarksheetBean bean) throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
		
		PreparedStatement pstmt = conn.prepareStatement("update marksheet set rollNo =?, name= ?, phy = ?, chm= ?, maths= ? where id = ?");
		
		pstmt.setInt(6, bean.getId());
		pstmt.setString(1, bean.getRollNo());
		pstmt.setString(2, bean.getName());
		pstmt.setInt(3, bean.getPhy());
		pstmt.setInt(4, bean.getChm());
		pstmt.setInt(5, bean.getMaths());
		
		int i = pstmt.executeUpdate();
		System.out.println(i+ " row affected(values inserted)");
	}
	public void delete(MarksheetBean bean) throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
		
		PreparedStatement pstmt = conn.prepareStatement("delete from marksheet where id= ?");
		pstmt.setInt(1, bean.getId());
		int i = pstmt.executeUpdate();
		System.out.println(i + " row affected (record deleted)");
		conn.close();
		pstmt.close();		
	}
	
}
