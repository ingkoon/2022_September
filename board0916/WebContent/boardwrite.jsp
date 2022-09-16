<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8") ;%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>끌쓰기</title>

<style type="text/css">
#main {
	width: 80%;
	border: 1px solid #aabbcc;
	margin: auto;
}
</style>
</head>
<body>

<div id="main">
<h3>글쓰기</h3>
	<form action="./boards" method="post">
	<input type="hidden" name="command" value="write">
		<table id="_tboard">
			<tr>
				<td>작성자</td>
				<td><input type="text" name="writer" width="30"></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="subject" width="30"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="20" cols="50" 
				name="content"></textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="글쓰기" ></td>
			</tr>
		</table>
	</form>
</div>
<a href='index.jsp'>HOME</a>
</body>
</html>