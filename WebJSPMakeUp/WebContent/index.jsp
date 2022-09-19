<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%!
	// declaration
	String name= "hong"; // 변수,메서드 선언 가능, 메서드 호출은 불가능	
	String getName(){
		return name;
	}

%>

<%
	// scriptlet
	int age = 21; // 변수 선언은 가능, 메서드의 선언은 불가능하다.
	for(int i = 0; i<10;i++){
		
	}
	if(true){
		
	}
	getName();
	response.sendRedirect(location);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
		<!--  expression -->
		<!-- 변수, 메서드의 호출은 가능하나 선언은 불가능하다. -->
		<%=getName() %>
		<%=name %> 
		${age}
</body>
</html>