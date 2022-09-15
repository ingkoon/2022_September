package helloservlet.com.ssafy.hello;

import java.util.List;

public interface IBoardDao {
	boolean addBoard(Board board);
	List<Board> getBoardList();
}
