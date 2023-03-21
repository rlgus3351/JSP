package com.smhrd.Frontcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Select;

import com.smhrd.controller.JoinService;
import com.smhrd.controller.LogoutService;
import com.smhrd.controller.SelectAllProgram;
import com.smhrd.controller.UpdateService;
import com.smhrd.controller.loginService;

@WebServlet("*.do")
// *.do -> 전체파일을 .do라는 확장자로 mapping 하여, 
//  .do가 붙어있는 경우 어떤 요청이라도 Frontcontroller로 연결하겠다.

public class Frontcontroller extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1. 요청된 uri 주소가 어디인지 확인!
		String uri = request.getRequestURI();
		System.out.println("요청된 uri : " + uri);

		// 2. 프로젝트의 이름 확인!
		String path = request.getContextPath();
		System.out.println("요청된 파일의 경로 : " + path);

		// 3. 1~2번을 활용하여 필요한 요청 이름 확인하기
		String result = uri.substring(path.length() + 1);
		System.out.println("result : " + result);
		// 요청된 내용에 따라 기능 연결!
		
		// 실행 이후 이동 url 저장을 위한 변수저장
		String moveURL = null;
		
		if (result.equals("Login.do")) {
			// Command가 가지고 있는 execute() 사용하여
			// 각각의 클래스 실행!
			
			// 로그인 클래스가 가지고 있는 execute();
			loginService login = new loginService();
			moveURL = login.execute(request, response);
		
		} else if (result.equals("Join.do")) {
			// Command가 가지고 있는 execute() 사용하여
			// 각각의 클래스 실행!
			
			// 조인 클래스가 가지고 있는 execute();
			JoinService join = new JoinService();
			moveURL = join.execute(request, response);
			
		} else if (result.equals("Update.do")) {
			UpdateService update = new UpdateService();
			moveURL = update.execute(request, response);
		} else if (result.equals("Logout.do")) {
			LogoutService logout = new LogoutService();
			moveURL = logout.execute(request, response);
		} else if (result.equals("SelectAll.do")) {
			SelectAllProgram select = new SelectAllProgram();
			moveURL = select.execute(request, response);
		} else {
			System.out.println("잘못된 요청입니다.");
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(moveURL);
		rd.forward(request, response);
	}

}
