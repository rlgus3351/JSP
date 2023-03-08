package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		// 2. 요청 받은 값 꺼내오기
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		// 하나의 name값에 요청받은 값이 여러개일때 꺼내오는 방법!
		// --> requst.getParametValues("name값")
		// --> return type : String 배열
		String gender = request.getParameter("gender");

		// 3. 응답 형식 지정하기
		response.setContentType("text/html;charset=UTF-8");

		// 4. 출력스트림 꺼내오기
		PrintWriter out = response.getWriter();

		// 5. 출력하기
//		out.print(id);
//		out.print(pw);
//		out.print(gender);

		// ----------------------DB--------------------------//
		int row = 0;
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement psmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String userid = "hr";
			String passwd = "hr";

			conn = DriverManager.getConnection(url, userid, passwd);
			String sql = "insert into LOGIN_TEST value (?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			psmt.setString(3, gender);

			row = psmt.executeUpdate();
			if (row > 0) {
				System.out.println("성공");
			} else {
				System.out.println("실패");
			}
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				if (rs != null)
					rs.close();
				if (psmt != null)
					psmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
