<%@page import="data.dao.ProfileDao"%>
<%@page import="data.dto.ProfileDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//1. 엔코딩
	request.setCharacterEncoding("utf-8");

	//2. 6개의 상품데이타 읽기
	String name=request.getParameter("name");
	String email=request.getParameter("email");
	String username=request.getParameter("username");
	String password=request.getParameter("password");
	String introduce=request.getParameter("introduce");
	String profilephoto=request.getParameter("profilephoto");
		
	//3. dto 에 넣기(생성자로 넣기)
	ProfileDto dto=new ProfileDto(name,email,username,password,introduce,profilephoto);
	
	//4. dao 선언
	ProfileDao dao=new ProfileDao();
	
	//5. insert 메서드 호출
	dao.insertProfile(dto);
	
	//6. shoplist.jsp 로 이동
	response.sendRedirect("LoginForm.jsp");
	
%>