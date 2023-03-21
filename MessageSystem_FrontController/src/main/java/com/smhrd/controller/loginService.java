package com.smhrd.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.model.MemberDAO;
import com.smhrd.model.MemberDTO;

@WebServlet("/loginService")
public class loginService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. 한글 인코딩 잡아주기
		request.setCharacterEncoding("UTF-8");

		// 2. 요청받은 데이터 꺼내오기(2개)
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");

		// 3. 데이터들을 하나로 묶어주기
		MemberDTO dto = new MemberDTO();
		dto.setEmail(email);
		dto.setPw(pw);

		// 4. DAO 생성하기
		MemberDAO dao = new MemberDAO();

		// 5. 로그인 기능 수행하기
		MemberDTO user = dao.login(dto);
		if (user != null) {
			// 6. 로그인 성공했다면 SESSION 로그인 정보를 저장
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			// 7. main.jsp로 redirect 방식으로 이동
		}
		response.sendRedirect("main.jsp");
	}

}
