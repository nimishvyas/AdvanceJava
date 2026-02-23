package com.rays.jdbc.preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.util.JDBCDataSource;

public class MarksheetModel {

	public int add(MarksheetBean bean) throws Exception{
		Connection conn = JDBCDataSource.getConnection();
		
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
		Connection conn = JDBCDataSource.getConnection();
		
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
		Connection conn = JDBCDataSource.getConnection();
		
		PreparedStatement pstmt = conn.prepareStatement("delete from marksheet where id= ?");
		pstmt.setInt(1, bean.getId());
		int i = pstmt.executeUpdate();
		System.out.println(i + " row affected (record deleted)");
		conn.close();
		pstmt.close();		
	}
	
	public MarksheetBean findByRollNo(String rollNo) throws Exception{
		Connection conn = JDBCDataSource.getConnection();
		
		PreparedStatement pstmt = conn.prepareStatement("select * from marksheet where rollNo = ?");
		pstmt.setString(1, rollNo);
		
		ResultSet rs = pstmt.executeQuery();
		MarksheetBean bean = null;
		
		while (rs.next()) {
			bean = new MarksheetBean();
			bean.setId(rs.getInt(1));
			bean.setRollNo(rs.getString(2));
			bean.setName(rs.getString(3));
			bean.setPhy(rs.getInt(4));
			bean.setChm(rs.getInt(5));
			bean.setMaths(rs.getInt(6));
		}
		return bean;
	}
	public MarksheetBean findByPk(int id) throws Exception{
		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("select * from marksheet where id= ?");
		pstmt.setInt(1, id);
		
		ResultSet rs = pstmt.executeQuery();
		MarksheetBean bean = null;
		while (rs.next()) {
			bean = new MarksheetBean();
			bean.setId(rs.getInt(1));
			bean.setRollNo(rs.getString(2));
			bean.setName(rs.getString(3));
			bean.setPhy(rs.getInt(4));
			bean.setChm(rs.getInt(5));
			bean.setMaths(rs.getInt(6));
		}
		return bean;
	}
	
	public List<MarksheetBean> meritList(MarksheetBean bean) throws Exception{
		Connection conn = JDBCDataSource.getConnection();
		
		PreparedStatement pstmt = conn.prepareStatement("select *, (phy+chm+maths) as total from marksheet where phy>=33 and chm>=33 and maths>=33 order by total desc limit 5");
		
		ResultSet rs = pstmt.executeQuery();
		
		List<MarksheetBean> list = new ArrayList<MarksheetBean>();
		while (rs.next()) {
			bean = new MarksheetBean();
			bean.setId(rs.getInt(1));
			bean.setRollNo(rs.getString(2));
			bean.setName(rs.getString(3));
			bean.setPhy(rs.getInt(4));
			bean.setChm(rs.getInt(5));
			bean.setMaths(rs.getInt(6));
			list.add(bean);
		}
		return list;
		
		
		
	}
	
}
