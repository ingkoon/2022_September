<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%!
	// declaration
	String name= "hong"; // ����,�޼��� ���� ����, �޼��� ȣ���� �Ұ���	
	String getName(){
		return name;
	}

%>

<%
	// scriptlet
	int age = 21; // ���� ������ ����, �޼����� ������ �Ұ����ϴ�.
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
		<!-- ����, �޼����� ȣ���� �����ϳ� ������ �Ұ����ϴ�. -->
		<%=getName() %>
		<%=name %> 
		${age}
</body>
</html>