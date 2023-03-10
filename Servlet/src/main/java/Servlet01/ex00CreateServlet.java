package Servlet01;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 1. url mapping 값 지정하는 방법
// - url mapping 이란?
// : Web browser에서 Servlet을 동작 시켰을 때, 실제 클래스 이름 대신 
//	 지정한 문자열을 url mapping (연결)하는 기법
//  ---> 사용하는 이유 :
// 		(1) 경로가 길어진다 ---> 불편하다.
//		(2) 경로가 그대로 표기되어 --> 보안상 문제가 발생

@WebServlet("/Create")
public class ex00CreateServlet extends HttpServlet {
	// 모든 Servlet 은 HttpServlet을 상속받는다!
	// ----> HttpServlet이 가지고 있는 메소드, 필드를 재사용 혹은 재정의 하는 것이 가능하다.
	// ----> HttpServlet은 apache tomcat servlet container에서 제공해준다!

	// 2. 객체 직렬화 ID
	// ---> 해당하는 파일이 Servlet임을 알려주는 고유의 ID 값
	// : 지워도 상관없지만, 지웠을 경우에 혹시나 문제가 발생할 수 있어서 그대로 두자!
	private static final long serialVersionUID = 1L;

	// 3. 생성자 : 객체 생성하는 순간에 호출되는 메소드
	public ex00CreateServlet() {
		super(); // ---> 부모클래스의 생성자 호출
		System.out.println("생성자 호출!");
	}

	// 4. init : (initialize)
	// : Servlet class에게 이제부터 Servlet이야 라고 이야기 메소드
	// ----------> Servletness
	// ---> 초기값을 설정하는 역할
	// 객체를 생성하고, 초기값을 설정하는 기능은 메모리(자원, 비용)를 많이 사용한다.
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Servlet 초기화 메소드 호출");
	}

	// 5. destory
	// : Servlet을 삭제하는 기능!(Server를 종료하면 호출되는 메소드)

	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destroy 메소드 호출");
	}

	// 6. service
	// : main method 같은 역할
	// : Client 요청을 처리해주는 메소드
	// ----> html 코드 출력, 조건문, 반복문 ~ 로직을 작성하는 구간
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Service 메소드 호출");
	}

	// 7. doGet, doPost
	// ---> Client로 부터 요청을 받는 방식은 여러개!
	// 요청방식(get, post)에 따라서 다른 기능을 수행하고 싶을 때 사용하는 메소드

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
