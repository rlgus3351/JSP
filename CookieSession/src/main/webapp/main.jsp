<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String nickName = (String)session.getAttribute("nickname");
	%>
	<%=nickName %>님 환영합니다.
	<a href="logout"> 로그아웃</a>
</body>
</html>