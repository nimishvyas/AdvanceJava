package com.jdbc.util;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public final class JDBCDataSource {

	private static ComboPooledDataSource cpds = null;
	
	private JDBCDataSource() {
		cpds = new ComboPooledDataSource();
		try {
			cpds.setDriverClass("com.mysql.cj.jdbc.Driver");
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cpds.setJdbcUrl("jdbc:mysql://localhost:3306/user");
		cpds.setUser("root");
		cpds.setPassword("root");
		cpds.setMaxPoolSize(30);
		cpds.setMinPoolSize(10);
		cpds.setInitialPoolSize(10);
		cpds.setAcquireIncrement(10);
	}
	
	private static JDBCDataSource jdbc = null;
	
	private static JDBCDataSource getInstance() {
		
		if (jdbc == null) {
			jdbc = new JDBCDataSource();
		}
		
		return jdbc;
	}
	
	public static Connection getConnection() {
		try {
			return getInstance().cpds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
