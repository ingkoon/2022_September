package edu.ssafy;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SingleParam
 */
public class SingleParam extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet................");
		String op1 = request.getParameter("op1");
		String op2 = request.getParameter("op2");
		request.setCharacterEncoding("utf-8");
		
		System.out.println(op1 + "," + op2);
		
		response.setContentType("text/htmll;charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.write("<div align=center><h1>p[1=" + op1 + ",op2=" + op2 + "</h1><div>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost................");		
		request.setCharacterEncoding("utf-8");
		
		String op1 = request.getParameter("op1");
		String op2 = request.getParameter("op2");
		request.setCharacterEncoding("utf-8");
		
		System.out.println(op1 + "," + op2);
		
		response.setContentType("text/htmll;charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.write("<div align=center><h1>p[1=" + op1 + ",op2=" + op2 + "</h1><div>");
	}
}
