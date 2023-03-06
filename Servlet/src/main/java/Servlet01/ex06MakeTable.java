package Servlet01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/MakeTable")
public class ex06MakeTable extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String temp1 = request.getParameter("num1");
		int num = Integer.parseInt(temp1);
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out  = response.getWriter();
		
		out.print("<table border=1;>");
		out.print("<tr>");
		for (int i = 0; i < num; i++) {
			out.print("<td>");
			out.print((i+1));
			out.print("</td>");
		}
		out.print("</tr>");
		
		out.print("</table>");
	}

}
