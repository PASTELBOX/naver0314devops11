<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//amho를 읽는다
	String amho = request.getParameter("amho");
	//amho가 1234면 쿠키에 amho라는 이름으로 저장
	if(amho.equals("1234")){
	Cookie cookie=new Cookie("amho","yes");
	cookie.setPath("/");//저장되는 위치
	cookie.setMaxAge(60*60*3);//3시간동안 유지
	response.addCookie(cookie);
	
	//cookiemain으로 이동
	response.sendRedirect("cookiemain.jsp");
	}else{%>
		<script>
			alert("암호가 맞지 않습니다");
			history.back();
		</script>
	<%}
	
%>