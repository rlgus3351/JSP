<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	fieldset{
	
		border-style: dashed  ;
		border-color: black;
	}
	*{
		align : center;
	}
</style>
</head>
<body>

	<fieldset>
		<%
			String id = request.getParameter("id");
		%>
		<strong> <%=id%>님 환영합니다!</strong>
		<br>
		
		<a href = "ex05Login.html">로그아웃</a>
	</fieldset>
</body>
</html>