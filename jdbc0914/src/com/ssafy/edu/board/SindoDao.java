package com.ssafy.edu.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc0914.DataBase2;

public class SindoDao extends DataBase2{
	public boolean insertBoard(SindoBoardDto dto) {
		
		String sql = "INSERT INTO sinboard(writer, title, content, wdate) VALUES" 
					+ "(?, ?, ?, now()) ";
		Connection conn = null;
		PreparedStatement psmt = null;
		
		int count = 0;
		try {
			conn = this.getConnection();
			System.out.println(this.getClass()+" insertBoard 2/6 S");
			psmt = conn.prepareStatement(sql);
			int j = 1;
			psmt.setString(j++, dto.getWriter());
			psmt.setString(j++, dto.getTitle());
			psmt.setString(j++, dto.getContent());
			System.out.println(this.getClass()+" insertBoard 3/6 S");
			count = psmt.executeUpdate();
			System.out.println(this.getClass()+" insertBoard 4/6 S");
			
		} catch (SQLException e) {
			System.out.println(this.getClass() + " insertBoard F" + e);		
		} finally {
			this.close(conn, psmt, null);
			System.out.println(this.getClass()+" insertBoard 6/6 S");
		}		
		return count > 0 ? true : false;
	}
	
	public List<SindoBoardDto> getBoardList() {
		
		String sql = "SELECT ids, writer, title, content, wdate FROM SINBOARD ORDER BY IDS";
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		List<SindoBoardDto> dtoList = new ArrayList<>();
				
		try {
			conn = this.getConnection();
			System.out.println(this.getClass()+" insertBoard 2/6 S");
			psmt = conn.prepareStatement(sql);			
			System.out.println(this.getClass()+" insertBoard 3/6 S");
			rs = psmt.executeQuery();
			System.out.println(this.getClass()+" insertBoard 4/6 S");
			while(rs.next()) {
				int i = 1;
				SindoBoardDto dto = new SindoBoardDto(
							rs.getInt(i++),
							rs.getString(i++),
							rs.getString(i++),
							rs.getString(i++),
							rs.getString(i++)
						);
				dtoList.add(dto);
			}
			
		} catch (SQLException e) {
			System.out.println(this.getClass() + " insertBoard F" + e);		
		} finally {
			this.close(conn, psmt, null);
			System.out.println(this.getClass()+" insertBoard 6/6 S");
		}		
		return dtoList;
	}
}
