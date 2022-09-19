package com.ssafy.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ssafy.member.model.MemberDto;
import com.ssafy.util.DBUtil;

public class MemberDaoImpl implements MemberDao {
	
	
	private static MemberDao memberDao = new MemberDaoImpl();
	private MemberDaoImpl() {};
	public static MemberDao getMemberDao() {
		return memberDao;
	}
	
	@Override
	public int idCheck(String userId) throws SQLException {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs =null;
		DBUtil dbutil = DBUtil.getInstance();
		
		try {
			conn = dbutil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select count(user_id) \n");
			sql.append("from members \n");
			sql.append("where user_id = ?");
			psmt = conn.prepareStatement(sql.toString());
			psmt = setString(1, userId);
			rs = psmt.executeQuery();
			rs.next();
			cnt = rs.getInt(1);
		}finally {
			dbutil.close(rs, psmt, conn);
		}
		
		return cnt;
	}

	private PreparedStatement setString(int i, String userId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int joinMember(MemberDto memberDto) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MemberDto loginMember(String userId, String userPwd) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
