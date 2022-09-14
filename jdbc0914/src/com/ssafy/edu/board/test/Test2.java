package com.ssafy.edu.board.test;

import java.util.ArrayList;
import java.util.List;

import com.ssafy.edu.board.SindoBoardDto;
import com.ssafy.edu.board.SindoDao;

public class Test2 {
	public static void main(String[] args) {
		SindoDao dao = new SindoDao();
		List<SindoBoardDto> dtoList = new ArrayList<>();
		dtoList = dao.getBoardList();
		for(SindoBoardDto dto : dtoList) {
			System.out.println(dto);
		}
	}
}
