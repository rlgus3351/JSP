package Servlet01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/MakeGugu")
public class ex07MakeGugu extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String color = request.getParameter("mycolor");
		String temp1 = request.getParameter("num1");
		String temp2 = request.getParameter("num2");
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		int number1 = Integer.parseInt(temp1);
		int number2 = Integer.parseInt(temp2);
		out.printf("<table border=1");
		for (int i = number1; i <= number2; i++) {
			out.printf("<tr bgcolor=%s>",color);
			for (int j = 1; j <= 9; j++) {
				out.print("<td>");
				out.print(i+"*"+j+"="+(i*j));
				out.print("</td>");
			}
			out.print("</tr>");
		}
		
		
		out.print("</table>");
	}

}

