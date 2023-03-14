package test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class sqlTest {
	
	static SqlSessionFactory sqlSessionFactory = null;
	static {
		String resource = "Configuration.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			System.out.println("초기화 성공");
		} catch (IOException e) {
			e.printStackTrace();
		}
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	// SqlSession 반환해주는 메서드
	public static SqlSession getSqlSession() {
		// 실제 사용자가 사용할 connection과 비슷한 객체
		SqlSession session = sqlSessionFactory.openSession();
		return session;
	}

}
