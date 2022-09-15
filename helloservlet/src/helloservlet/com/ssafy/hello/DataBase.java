package helloservlet.com.ssafy.hello;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class DataBase {
	String driver="com.mysql.cj.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/ssafyweb2?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC&useSSL=false";
	String user="ssafy";
	String pass="ssafy";
	public DataBase() {
		try {
			//1/6
			Class.forName(driver);
			System.out.println("1/6 Loading S");
		} catch (ClassNotFoundException e) {
			System.out.println("1/6 Loading F "+e);
		}
	}
	//2/6
	public Connection getConnection() throws SQLException {
		Connection conn=null;
		conn=DriverManager.getConnection(url,user, pass);
		return conn;
	}
	//6/6
	public void close(Connection conn, 
			PreparedStatement stmt, ResultSet rs) {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				
			}
		}
		if(stmt!=null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				
			}
		}
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				
			}
		}
	}
	
	
	
}
