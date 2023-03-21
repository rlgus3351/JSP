<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.smhrd.model.MemberDTO"%>
<!-- 1.request영역에 저장된 정보를 가져오시오. -->

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Forty by HTML5 UP</title>
<meta charset="UTF-8" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="assets/css/main.css" />

</head>
<style>
</style>
<body style="text-align: center;">
	<!-- Wrapper -->
	<%
			// request에 있는 list 꺼내오기
			ArrayList<MemberDTO> list = (ArrayList)request.getAttribute("list");
			
		%>
	<div id="wrapper">
		<!-- Menu -->
		<nav id="Update">
		<table>
			<caption>
				<h2>회원관리페이지</h2>
			</caption>
			<!-- 데이터가 존재하는 한 계속해서 반복적으로 내용을 꺼내올수 있는 구조 만들기! -->
			<%--<%if (list != null) {%>
			<% for(MemberDTO dto : list){ %>
			<tr>
				<td><%=dto.getEmail()%></td>
				<td><%=dto.getTel()%></td>
				<td><%=dto.getAddress()%></td>
			</tr>
			<% }%>
			<% }%> --%>
			<%for (int i=0; i<list.size(); i++){ %>
			<tr>
				<td><%=list.get(i).getEmail()%></td>
				<td><%=list.get(i).getTel()%></td>
				<td><%=list.get(i).getAddress()%></td>
			</tr>

			<%} %>
			<!-- 
							<c:if test = "${empty list}">
							
							</c:if>
							<c:if test = "${!empty list}">
								<c:forEach var ="list" items="${list}">
									<tr>
										<td>${list.email}</td>
										<td>${list.tel}</td>
										<td>${list.address}</td>							
									</tr>
								</c:forEach>
							</c:if>
							 -->
			<!-- 2.모든 회원의 이메일(email),전화번호(tel),주소(address)를 출력하시오. -->
		</table>
		</nav>
		<a href="main.jsp" class="button next scrolly">되돌아가기</a>
	</div>
	<!-- Scripts -->
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/jquery.scrolly.min.js"></script>
	<script src="assets/js/jquery.scrollex.min.js"></script>
	<script src="assets/js/skel.min.js"></script>
	<script src="assets/js/util.js"></script>
	<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
	<script src="assets/js/main.js"></script>
</body>
</html>

