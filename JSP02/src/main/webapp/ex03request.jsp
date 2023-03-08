<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.test{
		margin-left: 20px;		
	}
</style>
</head>
<body>
	<%	
		request.setCharacterEncoding("UTF-8");
		// 1. 요청 받은 데이터 꺼내오기
		String name = request.getParameter("name");
		
		// 2. 점수 데이터들은 전부 숫자로 변환하기
		int java_score = Integer.parseInt(request.getParameter("java_score"));
		int web_score = Integer.parseInt(request.getParameter("web_score"));
		int iot_score = Integer.parseInt(request.getParameter("iot_score"));
		int and_score = Integer.parseInt(request.getParameter("and_score"));
		
		//3. 평균 구하기
		int average = (java_score+web_score+iot_score+and_score)/4;
		
		// 4. 평균에 따른 학점을 구해주기
		String grade = "";
		if((average<101) && (average>=95)){
			grade = "A+";
		}else if(average>=90){
			grade = "A";
		}else if(average>=85){
			grade = "B+";
		}else if(average>=80){
			grade = "B";
		}else{
			grade = "F";
		}
		
	%>
	
	<!-- 5. 결과들을 전부 형식에 맞게 출력해주기 -->
	<fieldset>
		<legend>학점 확인 프로그램</legend>
		<table align='center'>
			<tr>
				<td>이름 : </td>
				<td class = "test"><%=name %></td>
			</tr>
			<tr>
				<td>JAVA점수 : </td>
				<td class = "test"><%=java_score %></td>
			</tr>
			<tr>
				<td>WEB점수 : </td>
				<td class = "test"><%=web_score %></td>
			</tr>
			<tr>
				<td>IOT점수 : </td>
				<td class = "test"><%=iot_score %></td>
			</tr>		
			<tr>
				<td>ANDROID점수 : </td>
				<td class = "test"><%=and_score %></td>
			</tr>		
			<tr>
				<td>학점 : </td>
				<td class = "test">
					<strong>
						<%=grade %>
					</strong>
				</td>
			</tr>			
		</table>
	</fieldset>
</body>
</html>
