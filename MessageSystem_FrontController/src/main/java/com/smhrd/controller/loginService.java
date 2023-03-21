package com.smhrd.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.model.MemberDAO;
import com.smhrd.model.MemberDTO;

public class loginService implements Command {
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 1. 한글 인코딩 잡아주기
		try {
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
//			response.sendRedirect("main.jsp");

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}	// 성공 실패해도 main.jsp로 이동하면 된다.

		return "main.jsp";
	}

}
