package Servlet01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Plus")
public class ex04Plus extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 요청 받은 데이터 꺼내오기
		String temp1 = request.getParameter("num1");
		String temp2 = request.getParameter("num2");
		
		// 2. 문자 자료형을 숫자로 형 변환
		// Integer --> Wrapper class
		//  Wrapper class란
		// -> 자바 기본자료형을 객체 형태로 변환한 class 들을 지칭
		
		int num1 = Integer.parseInt(temp1);
		int num2 = Integer.parseInt(temp2);
		
		// 3. 응답으로 돌려줄 자료형태를 지정(한글인코딩) 
		response.setContentType("text/html;charset=UTF-8");
		
		// 4. 출력 스트림 꺼내오기
		PrintWriter out = response.getWriter();
		
		// 5. 연산 결과를 웹페이지 출력하기
		int result = num1+num2;
		out.print("<h3>"+ num1 + "+" + num2 + "=" + result +"</h3>");
	
		
		
	}

}
