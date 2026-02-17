package com.rays.jdbc.preparedStatement;

import java.util.Date;

public class TestUserModel {

	public static void main(String[] args) throws Exception {
		testadd();
	}

	private static void testadd() throws Exception {
		UserModel model = new UserModel();
		UserBean bean = new UserBean();
		bean.setId(8);
		bean.setFirstName("Suraj");
		bean.setLastName("Sahu");
		bean.setLogin("suraj@gmail.com");
		bean.setPassword("suraj123");
		bean.setDob(new Date());

		model.add(bean);
		
	}
}
