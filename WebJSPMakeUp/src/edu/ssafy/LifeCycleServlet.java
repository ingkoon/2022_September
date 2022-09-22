package edu.ssafy;

import java.io.IOException;
import java.io.PrintWriter;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LifeCycleServlet
 */

//@WebServlet("/lifecycle.do")/
public class LifeCycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LifeCycleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() throws ServletException{
    	super.init();
    	System.out.println("init----------------------");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { 
    	super.service(req, resp);
    	System.out.println("service----------------------");
    }
    
    @Override
    public void destroy() {    	
    	super.destroy();
    	System.out.println("destroy----------------------");
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("doGet-----------------------------------------");
		PrintWriter writer = response.getWriter();
		writer.write("<h1>Ok Thank you</h1>");
		writer.flush();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		System.out.println("doPost-----------------------------------------");
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");

		// rd.forward(request, response);
		
		// response.sendRedirect("index.jsp");
	}

}
