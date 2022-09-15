package com.ssafy.edu.board;

import java.util.List;

public interface IBoardDao {
	boolean addBoard(Board board);
	List<Board> getBoardList();
}
