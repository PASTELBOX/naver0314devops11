<%@page import="data.dto.SawonDto"%>
<%@page import="data.dao.SawonDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	
	String photo=request.getParameter("photo");
	String name=request.getParameter("name");
	String addr=request.getParameter("addr");
	int age=Integer.parseInt(request.getParameter("age"));
	String birthday=request.getParameter("birthday");
	String buseo=request.getParameter("buseo");
	String gender=request.getParameter("gender");
	int num=Integer.parseInt(request.getParameter("num"));
	
	SawonDto dto=new SawonDto();
	dto.setPhoto(photo);
	dto.setName(name);
	dto.setAddr(addr);
	dto.setAge(age);
	dto.setBirthday(birthday);
	dto.setBuseo(buseo);
	dto.setGender(gender);
	dto.setNum(num);

	SawonDao dao=new SawonDao();

	dao.updateSawon(dto);

	response.sendRedirect("sawondetail.jsp?num="+num);
%>