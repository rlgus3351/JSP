package com.smhrd.model;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.smhrd.db.SqlSessionManager;

public class MemberDAO {

	// Data Access Object >> 데이터베이스에 있는 데이터에 접근 도와주는 객체

	// 1. Factory 가지고 오기(SqlSession을 빌려올 수 있는 공장)
	private SqlSessionFactory factory = SqlSessionManager.getFactory();

	public int join(MemberDTO dto) {
		int cnt = 0;

		// 회원 가입 기능 수행 --> 데이터 베이스에 데이터 추가하기
		// 데이터 베이스 접근하려면 connection(sqlsession) 필요

		// 1. sqlsession 빌려오기
		SqlSession session = factory.openSession(true);
		try {
			// 2. mapper.xml 파일안에 있는 sql구문 중에 사용하고 싶은 sql 구문 정해주기
			// session.insert("mapper파일식별자.sql구문식별자", mapper파일로 넘기고 싶은 매개변수)
			// session.update
			// session.delete
			cnt = session.insert("join", dto);
		} finally {
			// 3. sqlsession 반납
			session.close();
		}
		return cnt;
	}

}
