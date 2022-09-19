package com.ssafy.edu.board;
// OCP 

import java.util.List;

public interface IBoardDao {
   boolean addBoard(Board board);
   List<Board> getBoardList();
   Board getBoard(int article_no);
   boolean updateBoard(Board newBoard);
   boolean deleteBoard(int article_no);
}
 