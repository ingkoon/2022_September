package com.ssafy.board.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.board.model.BoardDto;
import com.ssafy.board.model.service.BoardService;
import com.ssafy.board.model.service.BoardServiceImpl;
import com.ssafy.member.model.MemberDto;
import com.ssafy.util.ParameterCheck;

@WebServlet("/board")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BoardService boardService;
	private Map<String, String> map;
	
	public void init() {
		boardService = BoardServiceImpl.getBoardService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("act");
		
		int pgNo = ParameterCheck.notNumberToOne(request.getParameter("pgno"));
		String key = ParameterCheck.nullToBlank(request.getParameter("key"));
		String word = ParameterCheck.nullToBlank(request.getParameter("word"));
		
		Map<String, String> map = new HashMap<>();
		map.put("pgno", pgNo + "");
		map.put("key", key);
		map.put("word", word);
		
		String path = "/index.jsp";
		if("list".equals(act)) {
			path = list(request, response);
			forward(request, response, path);
		} else if("mvwrite".equals(act)) {
			path = "/board/write.jsp";
			redirect(request, response, path);
		} else if("write".equals(act)) {
			path = write(request, response);
			forward(request, response, path);
		} else if("view".equals(act)) {
			path = view(request, response);
			forward(request, response, path);
		} else if("mvmodify".equals(act)) {
			path = mvModify(request, response);
			forward(request, response, path);
		} else if("modify".equals(act)) {
			path = modify(request, response);
			forward(request, response, path);
		} else if("delete".equals(act)) {
			path = delete(request, response);
			redirect(request, response, path);
		} else {
			redirect(request, response,path);
		}
	}
	
	private void forward(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}
	
	private void redirect(HttpServletRequest request, HttpServletResponse response, String path) throws IOException {
		response.sendRedirect(request.getContextPath() + path);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

	
	// 페이지를 가져오는 메서드
	private String list(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");
		
		if(memberDto != null) {
//			int pgNo = ParameterCheck.notNumberToOne(request.getParameter("pgno"));
//			String key = ParameterCheck.nullToBlank(request.getParameter("key"));
//			String word = ParameterCheck.nullToBlank(request.getParameter("word"));
//			
//			Map<String, String> map = new HashMap<>();
//			map.put("pgno", pgNo + "");
//			map.put("key", key);
//			map.put("word", word);
			try {
				List<BoardDto> list = boardService.listArticle(map);
				request.setAttribute("articles", list);
				return "/board/list.jsp";
			} catch (Exception e) {
				request.setAttribute("msg", "글목록 불러우는 중 에러발생!!!");;
				return "/error/error.jsp";
			}
		}else {
			return "/user/login.jsp";
				
		}	
	}

	private String write(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");
		
		//로그인을 하지않은 사람은 글을 쓸 수가 없다.
		if(memberDto != null) {
		BoardDto boardDto = new BoardDto();
		
		boardDto.setUserId(memberDto.getUserId());
		boardDto.setSubject(request.getParameter("subject"));
		boardDto.setContent(request.getParameter("content"));	
		try {
//			for (int i = 0; i < 200; i++) {
//				boardService.writeArticle(boardDto);
//				Thread.sleep(100);
//			}
			boardService.writeArticle(boardDto);
			return "/board?act=list";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "글작성 중에러발생!!!");;
			return "/error/error.jsp";
		}
	} else {
			return "/user/login.jsp";
				
	}
	}
	
	private String view(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");
		
		//로그인을 하지않은 사람은 글을 쓸 수가 없다.
		if(memberDto != null) {
			try {				
				int articleNo = Integer.parseInt(request.getParameter("articleno"));
				BoardDto boardDto = boardService.getArticle(articleNo);
				request.setAttribute("article", boardDto);								
				return "/board/list.jsp";
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("msg", "글목록 얻기 중 에러발생!!!");;
				return "/error/error.jsp";
			}
		} else {
			return "/user/login.jsp";		
		}
	}

	private String mvModify(HttpServletRequest request, HttpServletResponse response) {
		return "";
	}

	private String modify(HttpServletRequest request, HttpServletResponse response) {
		return "";
	}

	private String delete(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");
		
		//로그인을 하지않은 사람은 글을 쓸 수가 없다.
		if(memberDto != null) {
			try {				
				int articleNo = Integer.parseInt(request.getParameter("articleno"));
				boardService.deleteArticle(articleNo);				
				return "/board/list.jsp";
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("msg", "글 삭제 중 에러발생");;
				return "/"; // 보드 리스트로 이동
			}
		} else {
			return "/user/login.jsp";		
		}
	}
	
}
