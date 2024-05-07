<%@page import="java.sql.SQLException"%>
<%@page import="data.dto.FeedDto"%>
<%@page import="java.util.List"%>
<%@page import="data.dao.FeedDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main</title>
 <link href="css/style.css" rel="stylesheet">
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
    <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
    <script src="https://kit.fontawesome.com/88d284fba9.js" crossorigin="anonymous"></script>
	<style>
        .welcome-header__title{
            font-family: "Lobster", sans-serif;
            font-size: 20px;
        }
        body {
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            width: 100%;
        }
    </style>
</head>
<body class="base__body">
	<nav class="nav">
		<ul class="nav__list">
			<li class="welcome-header__title">INSTAKILOGRAM</li>
			<li class="nav__btn">
				<a class="nav__link" href="./MainForm.jsp">
					<i class="fa-solid fa-house fa-2x"></i>홈
				</a>
			</li>
			<li class="nav__btn">
				<a class="nav__link" href="./SearchForm.jsp">
					<i class="fa-solid fa-magnifying-glass fa-2x"></i>검색
				</a>
			</li>
			<li class="nav__btn">
				<a class="nav__link" href="./AddForm.jsp">
					<i class="fa-regular fa-square-plus fa-2x"></i>만들기
				</a>
			</li>
			<li class="nav__btn">
				<a class="nav__link" href="./ProfileForm.jsp">
					<i class="fa-regular fa-user fa-2x"></i>프로필
				</a>
			</li>
		</ul>
	</nav>
	
	<div class="top-bar">
        <% for (int i = 1; i <= 11; i++) { %>
            <img src="image/<%= i %>.jpg" alt="Image <%= i %>" class="top-bar__column-img">
        <% } %>
    </div>
	
	<div class="main-feed-container">
        <%
        FeedDao feedDao = new FeedDao();

        try {
            List<FeedDto> feeds = feedDao.getFeedDatas();

            for (FeedDto feed : feeds) {
                %>
                <div class="feed">
                    <img src="<%= feed.getFeedphoto() %>" class="feed__image">
                    <div class="feed-info">
                        <h5><%= feed.getTitle() %></h5>
                        <p><%= feed.getWritetime() %></p>
                        <p>Tags: <%= feed.getTag() %></p>
                        <p><%= feed.getText() %></p>
                    </div>
                </div>
                <%
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        %>
    </div>
    
</body>
</html>