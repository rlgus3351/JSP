package GetPost;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserInfo")
public class ex02UserInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1. post방식일 때 요청받은 데이터 한글 인코딩 해주기!
		request.setCharacterEncoding("UTF-8");

		// 2. 요청 받은 값 꺼내오기
		String job = request.getParameter("job");
		String gender = request.getParameter("gender");
		// 하나의 name값에 요청받은 값이 여러개일때 꺼내오는 방법!
		// --> requst.getParametValues("name값")
		// --> return type : String 배열
		String[] hobby = request.getParameterValues("hobby");

		// 3. 응답 형식 지정하기
		response.setContentType("text/html;charset=UTF-8");

		// 4. 출력스트림 꺼내오기
		PrintWriter out = response.getWriter();

		// 5. 출력하기
		out.print("<h3>");
		out.print("직업은  " + job);
		out.print("</h3>");
		out.print("<h3>");
		out.print("성별은  " + gender);
		out.print("</h3>");
		out.print("<h3>");
		out.print("취미 : ");

		for (String x : hobby) {
			out.print(x);
		}
		out.print("</h3>");

	}

}
