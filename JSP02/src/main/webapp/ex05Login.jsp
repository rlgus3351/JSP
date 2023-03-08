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
		// client 데이터를 가지고 페이지 이동 흐름 제어
		
		// 1. 요청 데이터 꺼내오기
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		// 2. 조건 판단(ID: smart, pw:123)
		if((id.equals("smart")) && (pw.equals("123"))){
			// 로그인 성공
			response.sendRedirect("ex05LoginSuccess.jsp?id="+id);
		}else{
			// 로그인 실패
			response.sendRedirect("ex05LoginFail.jsp");
		}
		
/* 		HTTP
		Connectionless(비연결성)
		- 클라이언트가 요청을 한 후 응답을 받으면 그 연결을 끊어 버리는 특징
		Stateless(무상태)
		- 통신이 끝나면 상태를 유지하지 않는 특징 */
		
	%>
</body>
</html>