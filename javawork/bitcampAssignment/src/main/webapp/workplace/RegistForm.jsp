<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration</title>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
 <link href="css/style.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
    <script src="https://kit.fontawesome.com/88d284fba9.js" crossorigin="anonymous"></script>
    <style>
        .regist-header__title{
            font-family: "Lobster", sans-serif;
        }
        
    </style>
</head>
<body style="border : 1px solid gray;border-radius : 5px;">
	<div class="regist-header">
      <img src="image/instagramlogo.png" id="regist-header__img"/>
      <h1 class="regist-header__title">INSTAKILOGRAM</h1>
    </div>
    
	<form action="./RegistAction.jsp" method="post" id="regist-form">
      <input name="username" type="text" placeholder="Username" />
      <input name="password" type="password" placeholder="Password" />
      <input name="email" type="email" placeholder="Email" />
      <input name="name" type="text" placeholder="Name" />
      <input name="introduce" type="text" placeholder="Text" />
      <select name="profilephoto" id="image-select" class="form-select">
            <%
                for (int i = 1; i <= 5; i++) { %>
                	<option value='image/<%=i%>.png'>
					프로필사진<%=i%>
					</option>
                <% }
            %>
      </select>
        
        <img src="image/1.png" class="rphoto"/>
      <input type="submit" value="Sign Up" />
    </form>
    
    <script type="text/javascript">
        $("#image-select").change(function() {
            $(".rphoto").attr("src",$(this).val())
        });
    </script>
</body>
</html>