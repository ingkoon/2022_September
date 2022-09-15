<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8") ;%> <!-- mime? -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTP-8">
<title>글쓰기</title>
</head>
<body>
<div id = "main">
<h3>글쓰기</h3>
	<form action="./boards" method = "post">
		<table id="_tboard">
			<tr>
				<td>작성자</td>
				<td><input type = "text" name = "writer" width="30"></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type = "text" name = "subject" width="30"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="10" cols="50" name="content"></textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="글쓰기"></td>
			</tr>
		</table>
	</form> <!-- alias를 사용하여야 한다. -->	
	
</div>
<a href='index.jsp'>HOME</a>
</body>
</html>

<!-- 한페이지가 웹 클래스이다. -->