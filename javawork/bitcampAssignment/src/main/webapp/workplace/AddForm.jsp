<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add</title>
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
    </style>
</head>
<body class="base__body">
    <nav class="nav">
        <ul class="nav__list">
            <li class="welcome-header__title">INSTAKILOGRAM</li>
            <li class="nav__btn">
                <a class="nav__link" href="./MainForm.jsp">
                    <i class="fa-solid fa-house fa-2x"></i> 홈
                </a>
            </li>
            <li class="nav__btn">
                <a class="nav__link" href="./SearchForm.jsp">
                    <i class="fa-solid fa-magnifying-glass fa-2x"></i> 검색
                </a>
            </li>
            <li class="nav__btn">
                <a class="nav__link" href="./AddForm.jsp">
                    <i class="fa-regular fa-square-plus fa-2x"></i> 만들기
                </a>
            </li>
            <li class="nav__btn">
                <a class="nav__link" href="./ProfileForm.jsp">
                    <i class="fa-regular fa-user fa-2x"></i> 프로필
                </a>
            </li>
        </ul>
    </nav>

    <div class="top-bar">
        <% for (int i = 1; i <= 11; i++) { %>
            <img src="image/<%= i %>.jpg" alt="Image <%= i %>" class="top-bar__column-img">
        <% } %>

    </div>

    <div class="add__container">
        <img src="" class="add__container-form__img"
		onerror="this.src='image/1.jpg'">
        <form action="AddAction.jsp" method="post" class="add__container-form">
        <h2 style="margin :50px;">Add Feed</h2>
            <table>
                <tr>
                    <td><label for="title">제목:</label>
                    <input type="text" id="title" name="title" class="add__container-form__input" required></td>
                </tr>
                <tr>
                    <td>					   
					<select class="add__container-form__input" name="photo" id="photo">
						<option value="no">사진 없음</option>
						<%
						for(int i=1;i<=11;i++){%>
							<option value="image/<%=i%>.jpg">사진#<%=i%></option>
						<%}
						%>
					</select>
					<script type="text/javascript">
						$("#photo").change(function(){
							let src=$(this).val();
							$(".add__container-form__img").attr("src",src);
						});
					</script>
				</td>
                </tr>
                <tr>
                    <td><label for="tag">태그:</label>
                    <input type="text" id="tag" name="tag" class="add__container-form__input" required></td>
                </tr>

                <tr>
                    <td><label for="text">텍스트:</label>
                    <textarea id="text" name="text" class="add__container-form__input" required></textarea></td>
                </tr>

                <tr>
                    <td><button type="submit" class="btn btn-primary">등록</button></td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
