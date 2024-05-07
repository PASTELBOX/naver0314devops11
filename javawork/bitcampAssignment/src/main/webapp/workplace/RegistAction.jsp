<%@page import="data.dao.ProfileDao"%>
<%@page import="data.dto.ProfileDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	String name=request.getParameter("name");
	String email=request.getParameter("email");
	String username=request.getParameter("username");
	String password=request.getParameter("password");
	String introduce=request.getParameter("introduce");
	String profilephoto=request.getParameter("profilephoto");
		
	ProfileDto dto=new ProfileDto(name,email,username,password,introduce,profilephoto);
	
	ProfileDao dao=new ProfileDao();
	
	dao.insertProfile(dto);
	
	response.sendRedirect("LoginForm.jsp");
%>