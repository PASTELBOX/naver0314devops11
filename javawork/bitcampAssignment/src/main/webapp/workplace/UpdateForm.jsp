<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="data.dto.ProfileDto" %>
<%@ page import="data.dao.ProfileDao" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로필 수정</title>
<link href="css/style.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<script src="https://kit.fontawesome.com/88d284fba9.js" crossorigin="anonymous"></script>
<style>
    .welcome-header__title {
        font-family: "Lobster", sans-serif;
        font-size: 20px;
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
</body>
</html>