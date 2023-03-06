package GetPost;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class ex01Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// post방식 일때 요청받은 데이터 한글 인코딩 해주기!
		request.setCharacterEncoding("utf-8");
		
		// 0. 데이터 가져오기
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		// 1. 응답형식 지정
		response.setContentType("text/html;charset=utf-8");

		// 2.출력 스트림 가져오기
		PrintWriter out = response.getWriter();

		// 3.데이터와 일치하는지 비교하여 웹 페이지에 출력
		if (id.equals("smart") && pw.equals("123")) {
			out.print(id + "님 환영합니다.");
		} else {
			out.print("로그인 정보를 확인하세요.");
			out.print("입력한 ID : " + id);
		}

	}

}
