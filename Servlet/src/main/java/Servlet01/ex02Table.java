package Servlet01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Table")
public class ex02Table extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ex02Table() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. 응답 형식 지정하기
		response.setContentType("text/html;charset=utf-8");

		// 2. 출력 스트림을 꺼내오기
		PrintWriter out = response.getWriter();

		// 3. Table태그를 출력하기
		// ---> 1행 6열 (1가로 6세로)

		out.print("<table border='1'>");
		// 행 : tr (table rows)
		out.print("<tr>");
		for (int j = 1; j < 7; j++) {
			// 열 : td (table data)
			out.print("<td>" + j + "</td>");
		}
		
		out.print("</tr>");
		out.print("</table>");

	}

}
