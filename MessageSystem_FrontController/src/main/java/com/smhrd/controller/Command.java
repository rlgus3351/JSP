package com.smhrd.controller;

import java.net.http.HttpRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
	
	// Command 역할 :
	// : 각 기능별 구체적인 내용은 달라지지만 같은 메소드의 이름으로 실행 할 수 있도록
	//   '정해진 틀'을 지정해주는 기능!
	
	// 추상 메소드
	// 같은 이름이지만 각 기능별 어떤 기능을 쓸지 모르겠다.
	// 하지만 같은 이름으로 호출하고 기능을 정리하여 쓰겠다!
	
	public abstract String execute(HttpServletRequest request, HttpServletResponse response);
	
	 
	
}
