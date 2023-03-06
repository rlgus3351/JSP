package Servlet01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Star")
public class h01Star extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String color = request.getParameter("mycolor");
		String temp1 = request.getParameter("num1");

		int number1 = Integer.parseInt(temp1);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<table border=1;>");
		for (int i = 1; i <= number1; i++) {
			if(i%2==1) {
				out.printf("<tr bgcolor=%s>",color);				
			}else {
				out.printf("<tr>");
			}
			for (int j = 1; j <= i; j++) {
				out.print("<td>");
				out.print("*");
				out.print("</td>");
			}
			out.print("</tr>");
		}
		out.print("</table>");
		
	}

}
