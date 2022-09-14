package com.ssafy.edu.test;

import jdbc0914.EmpDto;
import jdbc0914.HRDao;

public class DBtest3 {
	public static void main(String[] args) {
		HRDao dao = new HRDao();		
		EmpDto emp = dao.getEmp(100);
	
		System.out.println(emp);
	}
}
