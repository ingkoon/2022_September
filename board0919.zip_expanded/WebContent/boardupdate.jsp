<%@page import="com.ssafy.edu.board.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8") ;%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세보기</title>
<style type="text/css">
#main {
	width: 80%;
	border: 1px solid #aabbcc;
	margin: auto;
}
#_shows {
	
}
</style>
</head>
<body>
<%
Board board=null;
Object obj=request.getAttribute("board");
if(obj!=null){
	board=(Board)obj;
}
%>

<div id="main">
<h3>상세보기</h3>
<form action="./boards" method="post" >
<input type="hidden" name="command" value="update">
	<table id="_tboard">
	    <tr>
			<td>번호</td>
			<td><input type="text" name="article_no" readonly
			     value="<%=board.getArticle_no()%>" width="30"></td>
		</tr>
		<tr>
			<td>작성자</td>
			<td><input type="text" name="writer" readonly
			     value="<%=board.getUser_id() %>" width="30"></td>
		</tr>
		<tr>
			<td>제목</td>
			<td><input type="text" name="subject"  
			value="<%=board.getSubject() %>" width="30"></td>
		</tr>
		<tr>
			<td>작성일</td>
			<td><input type="text" name="register_time"  readonly
			value="<%=board.getRegister_time()%>" width="30"></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><textarea rows="20" cols="50" 
			name="content"><%=board.getContent()%></textarea></td>
		</tr>
		<tr>
			<td colspan="2">
			<input type="submit" value="글수정" >
			</td>
		</tr>
	</table>
</form>

</div>
<a href='index.jsp'>HOME</a>
</body>
</html>