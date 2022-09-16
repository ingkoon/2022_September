<%@page import="java.util.ArrayList"%>
<%@page import="com.ssafy.edu.board.Board"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8") ;%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
</head>
<body>

<%
List<Board> boards = new ArrayList<>();
Object obj = request.getAttribute("boards");
if(obj!=null){
	boards = (List<Board>)obj;
}
%>

<div id="main">
<h3>글 목록</h3>
	<table id="_tboard">
			<col width="10%">
			<col width="20%">
			<col width="50%">
			<col width="20%">
			<tr>
				 <td>번호</td> <td>작성자</td> <td>제목</td> <td>작성일</td>			
			</tr>
			<%
				if(boards==null || boards.size()==0){
					%>
					<tr>
					<td colspan="4"> 작성된 글이 없습니다.</td>
					</tr>
					<%
				}
			%>
			<%
			int cnt = 0;
			for(Board board : boards){
				%>
				<tr>
				<td><%=cnt++%></td>
				<td><%=board.getUser_id()%></td>
				<td> <a href='./boards?command=detail&article_no=<%=board.getArticle_no()%>'> <%=board.getSubject()%> </a> </td>
				<td><%=board.getRegister_time()%></td>
				<td><a href='./boards?command=delete&article_no=<%=board.getArticle_no()%>'>삭제</a></td>				
				</tr>			
				<%
			}
			%>
		</table>
	<a href='./boards?command=bfwrite'>글쓰기</a>
</div>
</body>
</html>