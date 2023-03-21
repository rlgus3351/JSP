package com.smhrd.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.model.MemberDAO;
import com.smhrd.model.MemberDTO;

public class SelectAllProgram implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		MemberDAO dao = new MemberDAO();		
		// 2. DAO 실행할 메소드 호출! -> selectAll()
		ArrayList<MemberDTO> list = dao.selectAll();
		
		// 3. 성공시 사용자의 정보 request객체에 전달!
		
		// 4. 해당 request를 가지고 페이지 이동! -> forward 방식
		if (list != null) {
			request.setAttribute("list", list);
		} 
//		RequestDispatcher rd= request.getRequestDispatcher("select.jsp");
//		rd.forward(request, response);
		return "select.jsp";
	}

}
