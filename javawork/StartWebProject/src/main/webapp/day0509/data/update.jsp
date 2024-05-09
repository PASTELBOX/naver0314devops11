<%@page import="data.dto.GuestDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="data.dao.GuestDao"%>
<%
    int num = Integer.parseInt(request.getParameter("num"));
    String nickname = request.getParameter("nickname");
    String content = request.getParameter("content");

    GuestDao dao = new GuestDao();
    GuestDto dto=new GuestDto();
	dto.setNickname(nickname);
	dto.setContent(content);
	dto.setNum(num);
    
    dao.updateGuest(dto);
%>