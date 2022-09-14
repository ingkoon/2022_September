package com.ssafy.edu.test;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc0914.HRDao;

public class DBtest1 {
	public static void main(String[] args) {
		HRDao dao = new HRDao();
		try {
			Connection conn = dao.getConnection();
			System.out.println("2/6 S");
			dao.close(conn, null, null);
			System.out.println("6/6 S");
		} catch(SQLException e) {
			System.out.println(e);
			System.out.println(" F " + e);
		}
		
	}
}
