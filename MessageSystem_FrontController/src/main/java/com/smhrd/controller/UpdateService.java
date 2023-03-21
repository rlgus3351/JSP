package com.smhrd.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.model.MemberDAO;
import com.smhrd.model.MemberDTO;

public class UpdateService implements Command {


	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 1. 인코딩 작업
		try {
			request.setCharacterEncoding("UTF-8");
			// 2. 수정하고자 넘겨준 데이터 꺼내오기

			// +) 수정하고자 하는 회원의 email 필요 -> session으로 부터 가져오기
			HttpSession session = request.getSession();
			MemberDTO user = (MemberDTO) session.getAttribute("user");
			String email = user.getEmail();
			String pw = request.getParameter("password");
			String tel = request.getParameter("tel");
			String address = request.getParameter("address");

			// 3. 데이터 MemberDTO 형태로 묶어주기
			MemberDTO dto = new MemberDTO(email, pw, tel, address);

			// 4. DAO로 접근할 수 있는 메소드 사용!
			MemberDAO dao = new MemberDAO();
			int row = dao.update(dto);
			if (row > 0) {
				// 회원 정보 수정 성공!
				// 수정된 내용을 기억하면서 main으로 넘어갈 수 있도록 설계!
				session.setAttribute("user", dto);
			} else {
				// 정보 수정 실패!
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "main.jsp";
	}

}
