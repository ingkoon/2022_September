package com.ssafy.edu.test;

import java.util.List;

import jdbc0914.EmpDto;
import jdbc0914.HRDao;

public class DBtest2 {
	public static void main(String[] args) {
		HRDao dao = new HRDao();
		List<EmpDto> emps = dao.getEmpList();
	
		for(EmpDto dto: emps) {
			System.out.println(dto);
		}
	}
}
