package com.ssafy.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BoardWrite
 */
@WebServlet("/register")
public class BoardWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
//		1. data get		
		request.setCharacterEncoding("utf-8");
		String userId = request.getParameter("userid");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");		
		System.out.println(userId + " " + subject + " " + content);
		
//		2. logic
		//emfkdlqj fheld, 디비 연결, sql 실행 준비, sql 실행, 데이터 입력
		
		
//		3. response page
	}

}
