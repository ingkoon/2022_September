package com.ssafy.edu.board.test;

import com.ssafy.edu.board.SindoBoardDto;
import com.ssafy.edu.board.SindoDao;

public class Test1 {
	public static void main(String[] args) {
		SindoDao dao = new SindoDao();
		boolean isSuccess = dao.insertBoard(
				new SindoBoardDto("injae", "오늘은 기분이 매우 좋은 날", "인재하고 싸웠다. 알고리즘내기에 이겼다. 돈 벌었다."));
		System.out.println(isSuccess);		
	}
}
