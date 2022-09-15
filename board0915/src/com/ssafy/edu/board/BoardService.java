package com.ssafy.edu.board;

public class BoardService {
	
	private static BoardService service = new BoardService();
	
	private BoardService() {
		dao = new BoardDaoImpl();
	}
	public static BoardService getInstance() {
		return service;
		
	}
	
	private IBoardDao dao;
	//---------------------------------------
	public boolean addBoard(Board board) {
		return dao.addBoard(board);
	}
}
