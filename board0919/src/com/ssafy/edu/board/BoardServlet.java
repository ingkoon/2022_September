package com.ssafy.edu.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Facade - controller �� ���� ����(����) -> MVC Pattern 
@WebServlet("/boards")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	BoardService service=BoardService.getInstance();
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		// �ϴ� �������� ��� ��û�� �𿴴ٰ� ���ϴ� ������ �̵��Ѵ�.
		String command=request.getParameter("command");
		if(command!=null && command.equalsIgnoreCase("bfwrite")) {
			response.sendRedirect("./boardwrite.jsp");
		}else if(command!=null && command.equalsIgnoreCase("write")) {
			String writer=request.getParameter("writer");
			String subject=request.getParameter("subject");
			String content=request.getParameter("content");
			boolean isS=service.addBoard(new Board(writer, subject, content));
			//�帧 - �׳ɰ� a location.href= response.sendRedirect
			//   -  ���ϴ� ��ü�� ������  forward - RequestDispatcher ���� 
			if(isS) {
				request.setAttribute("url","./boards?command=list");
				request.setAttribute("msg","�۾��⿡ �����߽��ϴ�.");
				request.setAttribute("title","�۸��");
				RequestDispatcher dispatch=request.getRequestDispatcher("./success.jsp");
				dispatch.forward(request, response); 
			}else {
				request.setAttribute("url","./boards?command=bfwrite");
				request.setAttribute("msg","�۾��⿡ �����߽��ϴ�.");
				request.setAttribute("title","�۾���");
				RequestDispatcher dispatch=request.getRequestDispatcher("./fail.jsp");
				dispatch.forward(request, response); 
			}
		}else if(command!=null && command.equalsIgnoreCase("list")) {
			request.setAttribute("boards",service.getBoardList());
			RequestDispatcher dispatch=request.getRequestDispatcher("./boardlist.jsp");
			dispatch.forward(request, response); 
		}else if(command!=null && command.equalsIgnoreCase("detail")) {
			String sarticle_no=request.getParameter("article_no");
			int article_no=Integer.parseInt(sarticle_no);
			request.setAttribute("board",service.getBoard(article_no));
			RequestDispatcher dispatch=request.getRequestDispatcher("./boarddetail.jsp");
			dispatch.forward(request, response); 
		}else if(command!=null && command.equalsIgnoreCase("bfupdate")) {
			String sarticle_no=request.getParameter("article_no");
			int article_no=Integer.parseInt(sarticle_no);
			request.setAttribute("board",service.getBoard(article_no));
			RequestDispatcher dispatch=request.getRequestDispatcher("./boardupdate.jsp");
			dispatch.forward(request, response); 
		}else if(command!=null && command.equalsIgnoreCase("update")) {
			String writer=request.getParameter("writer");
			String subject=request.getParameter("subject");
			String content=request.getParameter("content");
			String sarticle_no=request.getParameter("article_no");
			int article_no=Integer.parseInt(sarticle_no);
			Board newBoard=new Board(writer, subject, content);
			newBoard.setArticle_no(article_no);
			boolean isS=service.updateBoard(newBoard);
			//�帧 - �׳ɰ� a location.href= response.sendRedirect
			//   -  ���ϴ� ��ü�� ������  forward - RequestDispatcher ���� 
			if(isS) {
				request.setAttribute("url","./boards?command=detail&article_no="+article_no);
				request.setAttribute("msg","�ۼ����� �����߽��ϴ�.");
				request.setAttribute("title","�� �󼼺���");
				RequestDispatcher dispatch=request.getRequestDispatcher("./success.jsp");
				dispatch.forward(request, response); 
			}else {
				request.setAttribute("url","./boards?command=list");
				request.setAttribute("msg","�ۼ����� �����߽��ϴ�.");
				request.setAttribute("title","�۸��");
				RequestDispatcher dispatch=request.getRequestDispatcher("./fail.jsp");
				dispatch.forward(request, response); 
			}
		}else if(command!=null && command.equalsIgnoreCase("delete")) {
			String sarticle_no=request.getParameter("article_no");
			int article_no=Integer.parseInt(sarticle_no);
			boolean isS=service.deleteBoard(article_no);
			//�帧 - �׳ɰ� a location.href= response.sendRedirect
			//   -  ���ϴ� ��ü�� ������  forward - RequestDispatcher ���� 
			if(isS) {
				request.setAttribute("url","./boards?command=list");
				request.setAttribute("msg","�� ������ �����߽��ϴ�.");
				request.setAttribute("title","�۸��");
				RequestDispatcher dispatch=request.getRequestDispatcher("./success.jsp");
				dispatch.forward(request, response);  
			}else {
				request.setAttribute("url","./boards?command=list");
				request.setAttribute("msg","���� �������� ���߽��ϴ�.");
				request.setAttribute("title","�۸��");
				RequestDispatcher dispatch=request.getRequestDispatcher("./fail.jsp");
				dispatch.forward(request, response); 
			}
		}
	}
}//