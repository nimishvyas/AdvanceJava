package com.rays.jdbc.preparedStatement;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TestUserModel {

	
	public static void main(String[] args) throws Exception {
		//testadd();
		//testAuthenticate();
		//testSearch();
		testFindByPk();
		
	}

	private static void testFindByPk() throws Exception {
		UserModel model = new UserModel();
		UserBean bean = new UserBean();
		bean = model.findByPk(10);
		
		if (bean != null) {
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
		}else {
			System.out.println("User not found");
		}
	}

	private static void testSearch() throws Exception {
		UserModel model = new UserModel();
		UserBean bean = new UserBean();
		
		List<UserBean> list = model.search(bean);
		
		Iterator <UserBean> it = list.iterator();
		
		while(it.hasNext()) {
			bean = it.next();
			System.out.print(bean.getId());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
			System.out.println(bean.getLogin());
			System.out.println(bean.getPassword());
			System.out.println(bean.getDob());
			
		}
		
	}

	private static void testAuthenticate() throws Exception {
		UserModel model = new UserModel();
		UserBean bean = new UserBean();
		
		bean = model.authenticate("suraj@gmail.com", "suraj123");
		
		if (bean != null) {
			System.out.println("user logeed in");
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
		} else {
			System.out.println("invalid login or password");
		}
	}
	

	private static void testadd() throws Exception {
		UserModel model = new UserModel();
		UserBean bean = new UserBean();
		bean.setId(9);
		bean.setFirstName("furaj");
		bean.setLastName("Sahu");
		bean.setLogin("suraj@gmail.com");
		bean.setPassword("suraj123");
		bean.setDob(new Date());

		model.add(bean);
		
	}
	
}
