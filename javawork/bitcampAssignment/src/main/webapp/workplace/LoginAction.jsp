<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    if (password.equals("bitcamp")) {
        session.setAttribute("username", username);
        response.sendRedirect("MainForm.jsp");
    } else {%>
        <script>
        	alert("비밀번호가 맞지 않습니다!")
        	history.back();
        </script>
    <%}
%>