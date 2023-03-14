package com.smhrd.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.model.MemberDAO;
import com.smhrd.model.MemberDTO;

@WebServlet("/JoinService")
public class JoinService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		// 1. 한글 인코딩 잡아주기
		request.setCharacterEncoding("UTF-8");

		// 2. 요청받은 데이터들을 꺼내오기 
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String phoneNumber = request.getParameter("tel");
		String address = request.getParameter("address");
		
		// 3. 요청받은 데이터들을 하나의 자료형으로 묶어주기
		
		MemberDTO dto = new MemberDTO(email, pw, phoneNumber, address);
		
		// 4. 회원가입 기능 수행 하기
		// --> 데이터 베이스 연결과 관련된 기능
		
		MemberDAO dao = new MemberDAO();
		dao.join(dto);
		
		
	}

}
