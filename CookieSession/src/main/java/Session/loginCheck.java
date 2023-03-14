package Session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/loginCheck")
public class loginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		// 1. 요청 받은 데이터 꺼내오기
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		// 2. 조건을 판단(ID: test, PW:12345)
		if (id.equals("test") && pw.equals("12345")) {
			// 3. 참일시 session 생성해서 nickname 저장(쿠키몬스터)
			// main.jsp로 이동
			HttpSession session = request.getSession();
			session.setAttribute("nickname", "쿠키몬스터");
			response.sendRedirect("main.jsp");
		} else {
			// 4. 거짓이라면 loginForm.jsp로 이동
			response.sendRedirect("loginForm.jsp");
		}

	}

}
