package Session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/MakeSession")
public class ex01MakeSession extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 1. session 꺼내오기
		// >> session server에서 자동으로 생성
		// >> 발급한 session key를 browser 자동으로 보내기
		
		HttpSession session = request.getSession();
		
		// >> 요청이 들어온 client가 가지고있는 session id를 받아오기
		
		// 2. session영역에 데이터 저장하기
		
		session.setAttribute("name", "김운비");
		
		// Object value = "김운비"; >> 업캐스팅(Upcasting)
		// session 영역에는 모든 자료형태를 저장할 수 있다.
		
		// 3. ex02Session.jsp로 이동
		response.sendRedirect("ex02Session.jsp");
		
		
		
		
		
		
		
	}

}
