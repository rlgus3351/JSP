package Session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionListener;


@WebServlet("/logout")
public class logout extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 세션 삭제
		
		// 1. session 꺼내오기
		HttpSession session = request.getSession();
		
		// 2. session 안에 있는 데이터 삭제하기
		session.removeAttribute("nickname");
		
		// >> removeAttribute("name값");
		// >>>> 정확하게 지정한 name값에 있는 데이터만 삭제!
		
		// invalidate();
		// session 안에 저장되어 있는 모든 데이터 무효화
		
		session.invalidate();
		response.sendRedirect("main.jsp");
		
		
	}

}
