<%@ page import="data.dao.FeedDao"%>
<%@ page import="data.dto.FeedDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    request.setCharacterEncoding("utf-8");
    
    String title = request.getParameter("title");
    String photo = request.getParameter("photo");
    String tag = request.getParameter("tag");
    String text = request.getParameter("text");


    FeedDto dto = new FeedDto();
    dto.setTitle(title);
    dto.setFeedphoto(photo);
    dto.setTag(tag);
    dto.setText(text);

    FeedDao dao = new FeedDao();
    dao.insertFeed(dto);
    
    response.sendRedirect("MainForm.jsp");
%>