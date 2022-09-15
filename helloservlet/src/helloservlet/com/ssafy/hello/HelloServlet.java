package helloservlet.com.ssafy.hello;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
 
	private String name;
	public void init() {
		name = "¿Ã¿Œ¿Á";
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
//		1. data get
//		2. logic
//		3. response page ==> html
		PrintWriter out = response.getWriter();
		
		
		out.println("<html>");
		out.println("	<body>");
		out.println("		<h2>hello" + name+ "¥‘ æ»≥Á«œººø‰!</h2>");
		out.println("	</body>");
		out.println("</html>");
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String userId = request.getParameter("userid");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");		
		System.out.println(userId + " " + subject + " " + content);
		
		Connection conn = null;
		PreparedStatement psmt = null;
		int cnt = 0;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssafyweb?serverTimezone=UTC", "ssafy", "ssafy");
			StringBuilder sql = new StringBuilder();
			sql.append(" insert into board (user_id, subject, content) \r\n "); 
			sql.append(" values(?,?,?) ");			
			psmt = conn.prepareStatement(sql.toString());
			psmt.setString(1,  userId);
			psmt.setString(2,  subject);
			psmt.setString(3,  content);
			cnt = psmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(psmt!=null)
					psmt.close();
				if(conn!=null)
					conn.close();
			}catch()
		}
	}	

}
