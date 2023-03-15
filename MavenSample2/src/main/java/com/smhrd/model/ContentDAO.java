package com.smhrd.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.smhrd.db.SqlSessionManager;

public class ContentDAO {

	private SqlSessionFactory factory = SqlSessionManager.getFactory();

	public void selectALL() {
		SqlSession session = factory.openSession();
		try {
			// 2. mapper.xml 파일안에 있는 sql구문 중에 사용하고 싶은 sql 구문 정해주기
			// session.insert("mapper파일식별자.sql구문식별자", mapper파일로 넘기고 싶은 매개변수)
			// session.update
			// session.delete
			List<ContentDTO> dtoList = session.selectList("selectALL");
			if(dtoList.size()>0) {
				System.out.println("성공");
			}else {
				System.out.println("실패");
			}
		} finally {
			session.close();
		}
	}
}
