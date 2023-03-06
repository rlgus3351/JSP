package Servlet01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Op")
public class ex05Operation extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		// 1. 데이터 가져오기(3개)
		String temp1 = request.getParameter("num1");
		String temp2 = request.getParameter("num2");
		String op = request.getParameter("op");
		
		// 2. 데이터 형변환 (문자 -> 숫자)
		
		int num1 = Integer.parseInt(temp1);
		int num2 = Integer.parseInt(temp2);
		// 3. 응답 형식 지정
		response.setContentType("text/html;charset=UTF-8");
		
		// 4. 출력 스트림 가져오기
		PrintWriter out = response.getWriter();
		
		// 5. 연산기호에 따라 연산 결과를 구해주기
		int result = 0;
		switch (op) {
		case "+": 
			result = num1+num2;
			break;
		case "-":
			result = num1-num2;
			break;
		case "*":
			result = num1*num2;
			break;
		case "/":
			result = num1/num2;
			break;
		}
		
		// 6. 연산 결과를 웹페이지 출력하기
		out.print("<h3>");
		out.print(num1 + op + num2+ "=" + result);
		out.print("</h3>");
		
	}

}
