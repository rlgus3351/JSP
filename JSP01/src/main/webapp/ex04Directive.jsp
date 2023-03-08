<%@page import="java.util.ArrayList"%>
<!-- errorPage : 해당하는 파일에 문제가 발생했을 때 띄워줄 페이지를 지정 -->
<%@page errorPage="ex05Error.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- page 지시자 : JSP 페이지 내부의 전체적인 환경설정을 담당 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<%= 2/0 %>
	<!-- 지시자
		Web Container가 jsp를 Servlet class로 변환할 때 필요한 정보를 기술하기 위해 사용
		- page지시자, taglib지시자, include지시자
	 -->
	 <% 
	 // JSP에서 객체를 생성할 때는 자동완성 사용하기!
	 // ---> 자동완성 해야 import 구문이 자동으로 생성된다!
	 ArrayList<String> list = new ArrayList<>(); 
	 %>
	
</body>
</html>