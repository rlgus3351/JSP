<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>HELLO!</h1>
	<%-- 스크립트릿 주석
		JSP 구성요소
		1) 지시자(Directive) : <%@%>
		2) 선언문(DEclaration) : <%!%>
		3) 스크립트릿(Scriptlet) : <%%>
		>> jsp 내부에 java 코드를 삽입하고 싶을 때 사용!!
		
		4) 표현식(Expression) : <%=%>
		>> java 코드에서 작성한 변수, 객체, 메소드 결과를 웹페이지에 출력하고 싶을 때
		>> .java 변환 될 때 out.print()라는 메소가 실행되고
		>> 표현식을 적을때는 안쪽에 ;(세미콜론) 사용 금지!!
		
	--%>
	<%
		//자바 코드 공간
		// 1~10까지 h1태그 사용해서 출력
		for (int i=1; i<11; i++){%>
			<h1><%=i%></h1>
		<%}%>
	
	
	
	
	
	
	
	
	
	
</body>
</html>