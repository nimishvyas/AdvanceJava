package com.rays.jdbc.preparedStatement;

public class TestMarksheetModel {

	public static void main(String[] args) throws Exception{
		//testadd();
		//testDelete();
		testUpdate();
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
}
