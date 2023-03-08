<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<!--
		JSP 내장객체 (Implicit Object)
		: jsp파일이 .java(Servlet class)로 변환되는 순간에
		  내부적으로 자동으로 생성되는 객체를 명칭한다. 
		: 내가 직접 선언하지 않더라도 사용 가능한 객체!!
		  HttpRequest request = new HttpRequest(); >> xxxx 필요없다.
		1) out : HTML 문서에 출력을 도와주는 객체
		2) request : 요청 정보를 가지고 있는 객체
		3) response : 응답 정보를 가지고 있는 객체
	-->
	<table border = "1">
		<tr>
		<%for (int i=1; i<11; i++){ %>
			<td><%=i %></td>
			
			<% }%>
		</tr>
	</table>
	
<!-- out 객체 사용 -->
	<table border = "1">
		<tr>
		<%for (int i=1; i<11; i++){ 
			out.print("<td>"+i+"</td>");	
		}%>
		</tr>
	</table>
	
</body>
</html>