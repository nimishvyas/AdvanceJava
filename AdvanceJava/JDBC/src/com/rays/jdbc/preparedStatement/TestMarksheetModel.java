package com.rays.jdbc.preparedStatement;

import java.util.Iterator;
import java.util.List;

public class TestMarksheetModel {

	public static void main(String[] args) throws Exception{
		//testadd();
		//testDelete();
		//testUpdate();
		//testfindByRollNo();
		testMeritList();
	}

	private static void testMeritList() throws Exception {
		MarksheetModel model = new MarksheetModel();
		MarksheetBean bean = new MarksheetBean();
		
		List<MarksheetBean> list = model.meritList(bean);
		Iterator <MarksheetBean> it = list.iterator();
		while(it.hasNext()) {
			bean= it.next();
			System.out.println(bean.getId());
			System.out.println(bean.getRollNo());
			System.out.println(bean.getName());
			System.out.println(bean.getPhy());
			System.out.println(bean.getChm());
			System.out.println(bean.getMaths());
		}
		
	}

	private static void testUpdate() throws Exception{
		MarksheetModel model = new MarksheetModel();
		MarksheetBean bean = new MarksheetBean();
		
		bean.setId(16);
		bean.setRollNo("116");
		bean.setName("Arihant");
		bean.setPhy(69);
		bean.setChm(56);
		bean.setMaths(98);
		
		model.update(bean);
	}

	private static void testDelete() throws Exception {
		MarksheetModel model = new MarksheetModel();
		MarksheetBean bean = new MarksheetBean();
		
		bean.setId(16);
		model.delete(bean);
		
		
	}

	private static void testadd() throws Exception {
		MarksheetModel model = new MarksheetModel();
		MarksheetBean bean = new MarksheetBean();
		
		bean.setId(16);
		bean.setRollNo("116");
		bean.setName("Arihant");
		bean.setPhy(56);
		bean.setChm(68);
		bean.setMaths(78);
		
		model.add(bean);
		
	}
	
	private static void testfindByRollNo() throws Exception{
		MarksheetModel model = new MarksheetModel();
		MarksheetBean bean = new MarksheetBean();
		
		bean = model.findByRollNo("105");
		
		if( bean != null) {
			System.out.println(bean.getId());
			System.out.println(bean.getRollNo());
			System.out.println(bean.getName());
		} else {
			System.out.println("User Not Found");
		}
	}
	
}
