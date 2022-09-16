package com.ssafy.edu.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDaoImpl extends DataBase implements IBoardDao {
	
	public BoardDaoImpl() {
		super();
	}

	@Override
	public boolean addBoard(Board board) {
		StringBuilder sql=new StringBuilder();
		sql.append(" insert into board (user_id, subject, content) \r\n ");
		sql.append(" values(?,?,?) ");
		Connection conn=null;
		PreparedStatement psmt=null;
		int count=0;
		try {
			conn=getConnection();
			System.out.println(this.getClass()+" addBoard 2/6 S ");
			psmt=conn.prepareStatement(sql.toString());
			int j=1;
			psmt.setString(j++, board.getUser_id());
			psmt.setString(j++, board.getSubject());
			psmt.setString(j++, board.getContent());
			System.out.println(this.getClass()+" addBoard 3/6 S ");
			System.out.println(sql.toString());
			count=psmt.executeUpdate();
			System.out.println(this.getClass()+" addBoard 4/6 S ");
		} catch (SQLException e) {
			System.out.println(this.getClass()+" addBoard F "+e);
		} finally {
			this.close(conn, psmt, null);
			System.out.println(this.getClass()+" addBoard 6/6 S ");
		}
		return count>0 ?true:false;
	}

	@Override
	public List<Board> getBoardList() {
		List<Board> boards=new ArrayList<>();
		StringBuilder sql=new StringBuilder();
		sql.append(" select article_no, user_id, subject, content, hit, register_time \r\n ");
		sql.append(" from board order by article_no ");
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		try {
			conn=getConnection();
			System.out.println(this.getClass()+" getBoardList 2/6 S ");
			psmt=conn.prepareStatement(sql.toString());
			System.out.println(this.getClass()+" getBoardList 3/6 S ");
			System.out.println(sql.toString());
			rs=psmt.executeQuery();
			System.out.println(this.getClass()+" getBoardList 4/6 S ");
			while(rs.next()) {
				int i=1;
				Board board=new Board(
						rs.getInt(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getInt(i++),
						rs.getString(i++)
						);
				boards.add(board);
			}
			System.out.println(this.getClass()+" getBoardList 5/6 S ");
		} catch (SQLException e) {
			System.out.println(this.getClass()+" getBoardList F "+e);
		} finally {
			this.close(conn, psmt, rs);
			System.out.println(this.getClass()+" getBoardList 6/6 S ");
		}
		return boards;
	}

	@Override
	public Board getBoard(int article_no) {
		StringBuilder sql = new StringBuilder();
		sql.append(" select article_no, user_id, subject, content, hit, register_time \r\n ");
		sql.append(" from board where article_no = ? ");
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		Board board = null;
		try {
			conn=getConnection();
			System.out.println(this.getClass()+" getBoardList 2/6 S ");
			psmt=conn.prepareStatement(sql.toString());
			psmt.setInt(1, article_no);
			System.out.println(this.getClass()+" getBoardList 3/6 S ");			
			rs=psmt.executeQuery();
			System.out.println(this.getClass()+" getBoardList 4/6 S ");
			int i=1;
			while(rs.next()) {
			board=new Board(
					rs.getInt(i++),
					rs.getString(i++),
					rs.getString(i++),
					rs.getString(i++),
					rs.getInt(i++),
					rs.getString(i++)
					);
			}
			System.out.println(this.getClass()+" getBoardList 5/6 S ");
		} catch (SQLException e) {
			System.out.println(this.getClass()+" getBoardList F "+e);
		} finally {
			this.close(conn, psmt, rs);
			System.out.println(this.getClass()+" getBoardList 6/6 S ");
		}
		return board;
		
	}

	@Override
	public boolean updateBoard(Board board) {
		StringBuilder sql=new StringBuilder();
		sql.append(" update board  set subject=?, content=?, register_time=sysdate()  \r\n ");
		sql.append(" where article_no=? ");
		Connection conn=null;
		PreparedStatement psmt=null;
		int count=0;
		try {
			conn=getConnection();
			System.out.println(this.getClass()+" updateBoard 2/6 S ");
			psmt=conn.prepareStatement(sql.toString());
			int j=1;
			psmt.setString(j++, board.getSubject());
			psmt.setString(j++, board.getContent());
			psmt.setInt(j++, board.getArticle_no());
			System.out.println(this.getClass()+" updateBoard 3/6 S ");
			System.out.println(sql.toString());
			count=psmt.executeUpdate();
			System.out.println(this.getClass()+" updateBoard 4/6 S ");
		} catch (SQLException e) {
			System.out.println(this.getClass()+" updateBoard F "+e);
		} finally {
			this.close(conn, psmt, null);
			System.out.println(this.getClass()+" updateBoard 6/6 S ");
		}
		return count>0 ?true:false;
	}

	@Override
	public boolean deleteBoard(int article_no) {
		StringBuilder sql=new StringBuilder();
		sql.append(" delete from  board  \r\n ");
		sql.append(" where article_no= ? ");
		Connection conn=null;
		PreparedStatement psmt=null;
		int count=0;
		try {
			conn=getConnection();
			System.out.println(this.getClass()+" deleteBoard 2/6 S ");
			psmt=conn.prepareStatement(sql.toString());
			int j=1;			
			psmt.setInt(j++, article_no);
			System.out.println(this.getClass()+" deleteBoard 3/6 S ");
			System.out.println(sql.toString());
			count=psmt.executeUpdate();
			System.out.println(this.getClass()+" deleteBoard 4/6 S ");
		} catch (SQLException e) {
			System.out.println(this.getClass()+" deleteBoard F "+e);
		} finally {
			this.close(conn, psmt, null);
			System.out.println(this.getClass()+" deleteBoard 6/6 S ");
		}
		return count > 0 ? true: false;
	}
}