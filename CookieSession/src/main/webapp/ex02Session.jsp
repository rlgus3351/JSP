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
		// 1. session 안에 있는 데이터 꺼내오기
		// JSP -> .java(내장객체)
		
		String name = (String)session.getAttribute("name");
		
		// String name = (String)Object; >> 다운캐스팅
		
		// 다운캐스팅 정의
		// : 업캐스팅 된 객체를 다시 본래의 자료형으로 강제로 되돌리는 기술!
		
	%>
	<h3>session영역에 저장되어 있는 데이터 : <%= name %></h3>
	
	
</body>
</html>