package com.ssafy.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.member.model.service.MemberService;
import com.ssafy.member.model.service.MemberServiceImpl;

@WebServlet("/user")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MemberService memberService;
    
    public void init() {
    	memberService = MemberServiceImpl.getMemberService();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("act");
		
		String path = "/index.jsp";
		if("mvjoin".equals(act)) {			
		}else if("".equals(act)) {
//			path = idCheck(request, response);
			path = "/user/join.jsp";
			redirect(request, response, path);
		}
		else if("".equals(act)) {
			int cnt = idCheck(request, response);
			response.setCharacterEncoding(arg0);
		}
		else if("".equals(act)) {
			
		}
		else if("".equals(act)) {
			
		}else {
			redirect(request, response, path);
		}
	}

	private void redirect(HttpServletRequest request, HttpServletResponse response, String path) throws IOException {
		//매개변수가 uri, 
		response.sendRedirect(request.getContextPath()+path);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request,response);
	}
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	private String idCheck(HttpServletRequest request, HttpServletResponse response) {
		String userId = request.getParameter("userid");
		int count = memberService.idCheck(userId);
		return null;
	}

}
