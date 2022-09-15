package com.ssafy.board;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BoardView
 */
@WebServlet("/View")
public class BoardView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		// 
//		request.setCharacterEncoding("utf-8");
		
		int articleNo = Integer.parseInt(request.getParameter("article_no"));
		
		PrintWriter out = response.getWriter();
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
				
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssafyweb?serverTimezone=UTC", "ssafy", "ssafy");
			StringBuilder sql = new StringBuilder();
			
			sql.append(" select article_no, user_id, subject, content, hit, register_time \n ");
			sql.append("from board \n");
			sql.append("where article_no = ?");			
			psmt = conn.prepareStatement(sql.toString());
			psmt.setInt(1,  articleNo);
	
			rs = psmt.executeQuery();
			if(rs.next()) {
				response.setContentType("text/html;charset=utf-8");				
				out.println("        <div class=\"col-lg-8 col-md-10 col-sm-12\">");
				out.println("          <div class=\"row my-2\">");
				out.println("            <h2 class=\"text-secondary px-5\">" +rs.getString("subject") + "</h2>");
				out.println("          </div>");
				out.println("          <div class=\"row\">");
				out.println("            <div class=\"col-md-8\">");
				out.println("              <div class=\"clearfix align-content-center\">");
				out.println("                <img");
				out.println("                  class=\"avatar me-2 float-md-start bg-light p-2\"");
				out.println("                  src=\"https://raw.githubusercontent.com/twbs/icons/main/icons/person-fill.svg\"");
				out.println("                />");
				out.println("                <p>");
				out.println("                  <span class=\"fw-bold\">" +rs.getString("user_uid") + "</span> <br />");
				out.println("                  <span class=\"text-secondary fw-light\"" + rs.getString("register_time") + "조회" +  rs.getInt("hit") + "</span>");
				out.println("                </p>");
				out.println("              </div>");
				out.println("            </div>");
				out.println("            <div class=\"col-md-4 align-self-center text-end\">�뙎湲� : 17</div>");
				out.println("            <div class=\"divider mb-3\"></div>");
				out.println("            <div class=\"text-secondary\">");
				out.println(rs.getString("content"));
				out.println("              글 내용입니다. <br />");
				out.println("              글 내용입니다. <br />");
				out.println("              글 내용입니다. <br />");
				out.println("              글 내용입니다.<br />");
				out.println("              글 내용입니다. <br />");
				out.println("            </div>");
				out.println("            <div class=\"divider mt-3 mb-3\"></div>");
				out.println("            <div class=\"d-flex justify-content-end\">");
				out.println("              <button type=\"button\" id=\"btn-list\" class=\"btn btn-outline-primary mb-3\">");
				out.println("                글목록");
				out.println("              </button>");
				out.println("              <button type=\"button\" id=\"btn-mv-modify\" class=\"btn btn-outline-success mb-3 ms-1\">");
				out.println("                글수정");
				out.println("              </button>");
				out.println("              <button type=\"button\" id=\"btn-delete\" class=\"btn btn-outline-danger mb-3 ms-1\">");
				out.println("                글삭제");
				out.println("              </button>");
				out.println("            </div>");
				out.println("          </div>");
				out.println("        </div>");
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null)
					rs.close();
				if(psmt!=null)
					psmt.close();
				if(conn!=null)
					conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		out.println("      </div>");
		out.println("    </div>");
		out.println("    <script");
		out.println("      src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js\"");
		out.println("      integrity=\"sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p\"");
		out.println("      crossorigin=\"anonymous\"");
		out.println("    ></script>");
		out.println("    <script>");
		out.println("      document.querySelector(\"#btn-list\").addEventListener(\"click\", function () {");
		out.println("        location.href = \"/voard1_servlet/list\";");
		out.println("      });");
		out.println("      document.querySelector(\"#btn-mv-modify\").addEventListener(\"click\", function () {");
		out.println("        alert(\"글 수정하자!!!\");");
		out.println("        location.href = \"/voard1_servlet/list\";");
		out.println("      });");
		out.println("      document.querySelector(\"#btn-delete\").addEventListener(\"click\", function () {");
		out.println("        alert(\"글삭제하자!!!\");");
		out.println("        location.href = \"/voard1_servlet/list\";");
		out.println("      });");
		out.println("    </script>");
		out.println("  </body>");
		out.println("</html>");

	}

}
