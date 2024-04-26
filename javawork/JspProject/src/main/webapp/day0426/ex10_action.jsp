<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<link href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Dancing+Script:wght@400..700&family=East+Sea+Dokdo&family=Jua&family=Gaegu&family=Gamja+Flower&family=Pacifico&family=Single+Day&display=swap" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
    <style>
        body *{
            font-family: 'Jua';
        }
        div {
        	text-align : center;
        }
     </style>
</head>
<%
	request.setCharacterEncoding("utf-8");
	String menuname=request.getParameter("menuname");
	String foodphoto=request.getParameter("foodphoto");
	String grade=request.getParameter("grade");
	String member=request.getParameter("member");
	String []photo = foodphoto.split(",");
	String image = photo[0];
	String price = photo[1];
%>
<body>
	<div style="margin: 30px;font-size: 30px;width : 300px">
	메뉴명 : <%=menuname %><br>
	가 격 : <%=price %>원<br>
	<img src="<%=image %>" style="width : 300px; border : 2px"><br>
	만족도 : <%=grade %><br>
	우수회원 : <%=member==null?"X":"O" %><br>
</div>
</body>
</html>