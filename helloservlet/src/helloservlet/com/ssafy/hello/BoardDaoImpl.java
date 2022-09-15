package helloservlet.com.ssafy.hello;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class BoardDaoImpl extends DataBase implements IBoardDao {

	public BoardDaoImpl() {
		super();
	}
	
	public boolean addBoard(Board board) {
		StringBuilder sql = new StringBuilder();
		sql.append(" insert into board (user_id, subject, content) \r\n "); 
		sql.append(" values(?,?,?) ");
		Connection conn = null;
		PreparedStatement psmt = null;
		int count = 0;
		try {
			conn = getConnection();
			System.out.println(this.getClass() + " addBoard 2/6 S ");
			psmt = conn.prepareStatement(sql.toString());
			int j = 1;
			psmt.setString(j++, board.getUser_id());
			psmt.setString(j++, board.getSubject());
			psmt.setString(j++, board.getContent());
			System.out.println(this.getClass() + " addBoard 3/6 S ");
			System.out.println(sql.toString());
			count = psmt.executeUpdate();
			System.out.println(this.getClass()+" addBoard 4/6 S");
		} catch (SQLException e) {
			System.out.println(this.getClass() + " addBoard F " + e);			
		} finally {
			this.close(conn, psmt, null);
		}
		return count>0 ? true : false;
	}

	public List<Board> getBoardList() {
		// TODO Auto-generated method stub
		return null;
	}

}
